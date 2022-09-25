package example.show.web.controller;

import example.show.domain.entity.Show;
import example.show.domain.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/show")
@RequiredArgsConstructor
@Slf4j
public class ShowController {
    private final ShowRepository showRepository;

    @GetMapping
    public String shows() {
        log.info("show");
        return "shows";
    }

    @PostConstruct
    public void init(){
        List<String> actorSetA = new ArrayList<>();
        List<String> actorSetB = new ArrayList<>();

        actorSetA.add("actorA");
        actorSetA.add("actorB");

        actorSetB.add("actorB");
        actorSetB.add("actorC");

        Date dateA = new Date(2022, 12, 25, 0, 0);
        Date dateB = new Date(2022, 12, 26, 0, 0);

        showRepository.save(new Show("showA", actorSetA, dateA));
        showRepository.save(new Show("showB", actorSetB, dateB));
    }
}
