package example.show.web.service;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.Show;
import example.show.domain.repository.InMemShowRepository;
import example.show.domain.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService{

    private final ShowRepository showRepository;

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public List<Show> findShows(ShowSearchCond cond) {
        return showRepository.findAll(cond);
    }
}