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
    private Date startDate;
    private Date endDate;

    public Show(){
    }

    public Show(String showName, String place, List<String> actors, Date startDate, Date endDate) {
        this.showName = showName;
        this.place = place;
        this.actors = actors;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
