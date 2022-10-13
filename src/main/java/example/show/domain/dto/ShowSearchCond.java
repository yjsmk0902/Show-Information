package example.show.domain.dto;

import example.show.domain.entity.SearchType;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class ShowSearchCond {

    private SearchType searchType;      //ACTOR, SHOW, PLACE
    private String keyWord;
    private Map<String, Date> startEndDate;

    public ShowSearchCond() {}

}
