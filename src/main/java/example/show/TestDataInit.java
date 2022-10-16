package example.show;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.Show;
import example.show.domain.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {


    private final ShowRepository showRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() throws IOException, InterruptedException {

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
        for (WebElement select : elements) {
            try {
                WebElement title = select.findElement(By.className("tit"));
                WebElement day = select.findElement(By.className("day"));
                WebElement location = select.findElement(By.className("location"));

                log.info("title={}", title.getText());
                log.info("day={}", day.getText());
                log.info("location={}", location.getText());
            } catch (NoSuchElementException e) {
                break;
            }

        }



        log.info("Test Date Init");

        List<String> actorSetA = new ArrayList<>();
        List<String> actorSetB = new ArrayList<>();

        actorSetA.add("actorA");
        actorSetA.add("actorB");

        actorSetB.add("actorB");
        actorSetB.add("actorC");

        Date dateA = Date.valueOf("2022-09-02");
        Date dateB = Date.valueOf("2022-12-24");

        showRepository.save(new Show("showA", "세종문화회관", actorSetA, dateA ));
        showRepository.save(new Show("showB", "고양 아람누리", actorSetB, dateB));

    }
}
