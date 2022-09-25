package example.show.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SearchForm {

    private SearchType searchType;      //ACTOR, SHOW
    private String keyWord;
    private Date date;
}
