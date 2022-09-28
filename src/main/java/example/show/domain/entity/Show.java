package example.show.domain.entity;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Show {

    private Long id;
    private String showName;

    private String place;
    private List<String> actors;
    private LocalDate date;

    public Show(){
    }

    public Show(String showName, List<String> actors, LocalDate date) {
        this.showName = showName;
        this.actors = actors;
        this.date = date;
    }
}
