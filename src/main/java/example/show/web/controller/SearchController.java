package example.show.web.controller;

import example.show.domain.dto.SearchDTO;
import example.show.domain.entity.SearchType;
import example.show.domain.entity.Show;
import example.show.domain.repository.ShowRepository;
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

    private static final ShowRepository showRepository = new ShowRepository();

    @ModelAttribute("searchTypes")
    public SearchType[] searchType() {
        return SearchType.values();
    }

    @GetMapping
    public String searchDTO(Model model) {
        List<Show> shows = showRepository.findAll();
        model.addAttribute("searchDTO", new SearchDTO());
        model.addAttribute("shows", shows);
        return "shows";
    }

    @PostMapping
    public String search(SearchDTO searchDto, RedirectAttributes redirectAttributes) {
        log.info("searchDto.searchType={}", searchDto.getSearchType());
        log.info("searchDto.keyWord={}", searchDto.getKeyWord());
        log.info("searchDto.date={}", searchDto.getDate());
        return "shows";
    }



}
