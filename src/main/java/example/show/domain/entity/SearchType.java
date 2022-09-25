package example.show.domain.entity;

public enum SearchType {
    ACTOR("배우"), SHOW("공연");

    private final String description;

    SearchType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
