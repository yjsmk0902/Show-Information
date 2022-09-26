package example.show.domain.dto;

import example.show.domain.entity.SearchType;
import lombok.Data;

import java.util.Date;

@Data
public class SearchDTO {

    private SearchType searchType;      //ACTOR, SHOW
    private String keyWord;
    private String date;
}
