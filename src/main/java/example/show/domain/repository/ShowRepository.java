package example.show.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import example.show.domain.dto.SearchType;
import example.show.domain.dto.ShowSearchCond;
import example.show.domain.entity.Show;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ShowRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(Show show) {
        em.persist(show);
    }

    public Show findOne(Long id) {
        return em.find(Show.class, id);
    }

    public List<Show> findAll() {
        return em.createQuery("select s from Show s", Show.class)
                .getResultList();
    }

    public List<Show> findByName(String name) {
        return em.createQuery("select s from Show s where s.name = :name", Show.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Show> findBySearchCond(ShowSearchCond cond) {

        String keyWord = cond.getKeyWord();
        String startEndDate = cond.getStartEndDate();

        LocalDate startDate;
        LocalDate endDate;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (startEndDate != null) {
            String[] dateRange = startEndDate.split("~");
            startDate = LocalDate.parse(dateRange[0], format);
            endDate = LocalDate.parse(dateRange[1], format);
        }else{
            startDate = LocalDate.now();
            endDate = LocalDate.parse("2030-12-31", format);
        }
        return null;
    }
}
