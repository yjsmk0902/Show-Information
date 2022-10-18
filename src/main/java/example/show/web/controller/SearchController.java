package example.show.web.controller;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.dto.SearchType;
import example.show.domain.entity.Show;
import example.show.web.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search")
public class SearchController {

    private final ShowService showService;
    @ModelAttribute("searchTypes")
    public SearchType[] searchType() {
        return SearchType.values();
    }

    @GetMapping
    public String shows(@ModelAttribute("showSearch") ShowSearchCond showSearch, Model model) {
        List<Show> shows = showService.findShows(showSearch);
        model.addAttribute("shows", shows);
        return "shows";
    }

}
