package example.show;

import example.show.domain.entity.Show;
import example.show.domain.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final ShowRepository showRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("Test Date Init");

        List<String> actorSetA = new ArrayList<>();
        List<String> actorSetB = new ArrayList<>();

        actorSetA.add("actorA");
        actorSetA.add("actorB");

        actorSetB.add("actorB");
        actorSetB.add("actorC");

        Date dateA = Date.valueOf("2022-09-02");
        Date dateB = Date.valueOf("2022-12-24");

        showRepository.save(new Show("showA", actorSetA, dateA));
        showRepository.save(new Show("showB", actorSetB, dateB));
    }
}
