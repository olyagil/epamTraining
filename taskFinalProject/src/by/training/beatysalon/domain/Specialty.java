package by.training.beatysalon.domain;

public enum Specialty {

    DERMATOLOGIST("дерматолог"),
    COSMETOLOGIST("косметолог");


    private String name;

    Specialty(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static Specialty getById(Integer id) {
        return Specialty.values()[id];
    }

}
