package example.show.domain.repository;

import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.SearchType;
import example.show.domain.entity.Show;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class InMemShowRepository implements ShowRepository {

    private static final Map<Long, Show> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Show save(Show show) {
        show.setId(++sequence);
        store.put(show.getId(), show);
        return show;
    }

    @Override
    public List<Show> findAll(ShowSearchCond cond) {

        log.info("Mem find start");

        SearchType searchType = cond.getSearchType();
        String keyWord = cond.getKeyWord();
        String startEndDate = cond.getStartEndDate();

        Date startDate;
        Date endDate;

        if (startEndDate != null) {
            String[] dateRange = startEndDate.split("~");
            startDate = Date.valueOf(dateRange[0]);
            endDate = Date.valueOf(dateRange[1]);
        }else{
            startDate = Date.valueOf(LocalDate.now());
            endDate = Date.valueOf("2030-12-31");
        }

        log.info("Mem data init end");
        log.info("searchType={}", searchType);
        log.info("keyWord={}", keyWord);
        log.info("startDate={}, endDate={}", startDate, endDate);

        if (searchType == null) {
            return new ArrayList<>(store.values());
        }else{
            switch (searchType) {
                case SHOW:
                    return store.values().stream()
                            .filter(show -> {
                                if (ObjectUtils.isEmpty(keyWord)) {
                                    return true;
                                }
                                return show.getShowName().contains(keyWord);
                            }).filter(show -> {
                                if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty((endDate))) {
                                    return true;
                                }
                                return show.getDate().after(startDate) && show.getDate().before(endDate);
                            })
                            .collect(Collectors.toList());
                case ACTOR:
                    return store.values().stream()
                            .filter(actors -> {
                                if (ObjectUtils.isEmpty(keyWord)) {
                                    return true;
                                }
                                return actors.getActors().contains(keyWord);
                            }).filter(show -> {
                                if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty((endDate))) {
                                    return true;
                                }
                                return show.getDate().after(startDate) && show.getDate().before(endDate);
                            })
                            .collect(Collectors.toList());
                case PLACE:
                    return store.values().stream()
                            .filter(place -> {
                                if (ObjectUtils.isEmpty(keyWord)) {
                                    return true;
                                }
                                return place.getPlace().contains(keyWord);
                            }).filter(show -> {
                                if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty((endDate))) {
                                    return true;
                                }
                                return show.getDate().after(startDate) && show.getDate().before(endDate);
                            })
                            .collect(Collectors.toList());
                default:
                    return new ArrayList<>(store.values());
            }
        }

    }
}