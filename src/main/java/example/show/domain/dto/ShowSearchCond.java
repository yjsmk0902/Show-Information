package example.show.domain.dto;

import lombok.Data;

@Data
public class ShowSearchCond {

    private SearchType searchType;     //ACTOR, SHOW, PLACE
    private String keyWord;
    private String startEndDate;

    public ShowSearchCond() {}

}
