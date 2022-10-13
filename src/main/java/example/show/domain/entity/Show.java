package example.show.domain.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Show {

    private Long id;
    private String showName;

    private String place;
    private List<String> actors;
    private Date date;

    public Show(){
    }
    public Show(String showName, String place, List<String> actors, Date date) {
        this.showName = showName;
        this.place = place;
        this.actors = actors;
        this.date = date;
    }
}
