package example.show.web.controller;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.SearchType;
import example.show.domain.entity.Show;
import example.show.domain.repository.InMemShowRepository;
import example.show.domain.repository.ShowRepository;
import example.show.web.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping
    public String search(@ModelAttribute ShowSearchCond showSearchCond, RedirectAttributes redirectAttributes) {
        log.info("searchDto.searchType={}", showSearchCond.getSearchType());
        log.info("searchDto.keyWord={}", showSearchCond.getKeyWord());
        log.info("searchDto.startEndDate={}", showSearchCond.getStartEndDate());
        return "shows";
    }


}
