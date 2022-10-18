package example.show.domain.dto;

public enum SearchType {
    ACTOR("배우"), SHOW("공연"), PLACE("장소");

    private final String description;

    SearchType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
