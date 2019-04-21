package by.training.beatysalon.domain;


import java.sql.Date;
import java.util.List;

public class Client extends Person {

    private Date birthDate;
    private List<Talon> currentTalons;
    private List<Talon> usedTalons;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "\nClient{" + super.toString() +
                ", birthDate=" + birthDate +
                ", currentTalons=" + currentTalons +
                ", usedTalons=" + usedTalons +
                "} ";
    }
}
