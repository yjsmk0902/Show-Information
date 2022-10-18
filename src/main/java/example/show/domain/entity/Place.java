package example.show.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue
    private String name;

    @OneToMany(mappedBy = "place")
    private List<Show> show = new ArrayList<>();
}
