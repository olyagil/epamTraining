package by.training.beatysalon.domain;


import java.util.List;

public class Client extends Person {

    private String cardNumber;
    private String phone;
    private List<Talon> currentTalons;
    private List<Talon> usedTalons;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Talon> getCurrentTalons() {
        return currentTalons;
    }

    public void setCurrentTalons(List<Talon> currentTalons) {
        this.currentTalons = currentTalons;
    }

    public List<Talon> getUsedTalons() {
        return usedTalons;
    }

    public void setUsedTalons(List<Talon> usedTalons) {
        this.usedTalons = usedTalons;
    }

    @Override
    public String toString() {
        return "\nClient{" + super.toString() +
                "cardNumber='" + cardNumber + '\'' +
                ", phone='" + phone + '\'' +
                "} ";
    }
}
