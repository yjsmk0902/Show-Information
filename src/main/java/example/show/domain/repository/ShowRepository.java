package example.show.domain.repository;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.Show;

import java.util.List;

public interface ShowRepository {

    Show save(Show show);


    List<Show> findAll(ShowSearchCond cond);
}
