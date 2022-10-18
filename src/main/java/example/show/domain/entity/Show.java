package example.show.domain.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Show {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime showTime;     //관람 시간

    private LocalDateTime startShow;    //공연 기간 (시작)
    private LocalDateTime endShow;      //공연 기간 (종료)

    private Integer viewGrade;          //관람 등급

    private String genre;               //장르

    @OneToMany(mappedBy = "show")
    private List<ShowActor> showActors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

}
