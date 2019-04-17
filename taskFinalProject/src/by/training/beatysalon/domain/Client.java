package by.training.beatysalon.domain;


import java.sql.Date;
import java.util.List;

public class Client extends Person {

    private Date birth_date;

    private List<Talon> currentTalons;
    private List<Talon> usedTalons;

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
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
        return "Client{" + super.toString() +
                "birth_date=" + birth_date +
                ", currentTalons=" + currentTalons +
                ", usedTalons=" + usedTalons +
                "} ";
    }
}
