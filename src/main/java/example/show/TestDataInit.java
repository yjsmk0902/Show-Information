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
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {


    private final ShowRepository showRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() throws IOException {

        String SOURCE_URL = "http://ticket.melon.com/concert/index.htm?genreType=GENRE_ART";
        Connection con = Jsoup.connect(SOURCE_URL);

        Document doc = con.get();
        Elements elements = doc.select("ul.list_main_concert");

        for (Element select : elements) {
            log.info("select={}", select);
        }
        log.info("elements={}", elements);



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
