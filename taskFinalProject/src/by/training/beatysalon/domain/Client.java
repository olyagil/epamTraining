package by.training.beatysalon.domain;


import java.util.List;

public class Client extends Entity {

    private String cardNumber;
    private String name;
    private String phone;
    private List<Talon> currentTalons;
    private List<Talon> usedTalons;

}
