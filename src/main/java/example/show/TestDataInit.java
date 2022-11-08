package example.show;

import example.show.domain.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {


    private final ShowRepository showRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() throws InterruptedException {

        seleniumTest();

        log.info("Test Date Init");

        List<String> actorSetA = new ArrayList<>();
        List<String> actorSetB = new ArrayList<>();

        actorSetA.add("actorA");
        actorSetA.add("actorB");

        actorSetB.add("actorB");
        actorSetB.add("actorC");

        Date dateA = Date.valueOf("2022-09-02");
        Date dateB = Date.valueOf("2022-12-24");

       // showRepository.save(new Show("showA", "세종문화회관", actorSetA, dateA));
        //showRepository.save(new Show("showB", "고양 아람누리", actorSetB, dateB));

    }

    public void seleniumTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-notifications");

        //WebDriver 설정
        WebDriver driver;
        String SOURCE_URL = "http://ticket.melon.com/concert/index.htm?genreType=GENRE_ART";

        //Properties 설정
        String WEB_DRIVER_ID = "webdriver.chrome.driver";
        String WEB_DRIVER_PATH = "/Users/luke/Desktop/Spring/chromedriver";

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(SOURCE_URL);
        //Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.cssSelector("#perf_poster li"));
        log.info("elements={}", elements);

        List<String> urls = new ArrayList<>();

        for (WebElement select : elements) {
            try {
                WebElement tag = select.findElement(By.tagName("a"));
                urls.add(tag.getAttribute("href"));
            } catch (NoSuchElementException e) {
                break;
            }
        }

        for (String link : urls) {

            driver.get(link);
            String showName = driver.findElement(By.xpath("//*[@id=\"conts\"]/div/div[1]/div[1]/div[2]/p[2]")).getText();
            String location = driver.findElement(By.xpath("//*[@id=\"performanceHallBtn\"]")).getAttribute("title");
            String dateRange = driver.findElement(By.xpath("//*[@id=\"periodInfo\"]")).getText();

            shutPopWindow(driver, link);
            shutPopWindow(driver, link);
            shutPopWindow(driver, link);
            driver.findElement(By.xpath("//*[@id=\"ticketing_process_box\"]/div/div[1]/dl[1]/dd[1]/button[2]")).click();

            String[] split = dateRange.split(" - ");
            DateTimeFormatter stringToLocalDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate startDate = LocalDate.parse(split[0], stringToLocalDate);
            LocalDate endDate = LocalDate.parse(split[1], stringToLocalDate);
            LocalDate cursorDate = startDate;

            List<WebElement> dateChoice = driver.findElements(By.cssSelector("#list_date li button"));
            log.info("dateChoice={}", dateChoice);
            for (WebElement date : dateChoice) {
                date.click();
                List<WebElement> timeChoice = driver.findElements(By.xpath("//*[@id=\"list_time\"]"));
                for (WebElement time : timeChoice) {
                    String showTime = driver.findElement(By.className("txt")).getText();
                    String actor = driver.findElement(By.className("casting-name")).getText();
                    log.info("showTime={}", showTime);
                    log.info("actor={}", actor);
                }
            }

            log.info("=======================");
            log.info("showName = {}", showName);
            log.info("location = {}", location);
            log.info("startDate={}, endDate={}", startDate, endDate);
            log.info("=======================");
        }
        driver.close();
        driver.quit();

    }

    public void shutPopWindow(WebDriver driver, String url) {
        driver.get(url);
        String main = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(main)) {
                driver.switchTo().window(handle).close();
            }
        }
    }
}
