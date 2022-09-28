package example.show.domain.dto;

import example.show.domain.entity.SearchType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Data
public class SearchDTO {

    private SearchType searchType;      //ACTOR, SHOW
    private String keyWord;

    private Map<String, LocalDate> startEndDate;

}
