package by.training.beautysalon.domain;

public enum Role {

    ADMINISTRATOR("администратор"),
    SPECIALIST("специалист"),
    CLIENT("клиент"),
    GUEST("гость");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static Role getById(Integer id) {
        return Role.values()[id];
    }
}
