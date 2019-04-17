package by.training.beatysalon.domain;

import java.util.Date;
import java.util.List;

public class Specialist extends Person {

    private Specialty specialty;
    private Date beginWorkingDay;
    private Date endWorkingDay;
    private Integer cabinetNumber;
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private List<Talon> usedTalons;
    private List<Talon> takenTalons;

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Date getBeginWorkingDay() {
        return beginWorkingDay;
    }

    public void setBeginWorkingDay(Date beginWorkingDay) {
        this.beginWorkingDay = beginWorkingDay;
    }

    public Date getEndWorkingDay() {
        return endWorkingDay;
    }

    public void setEndWorkingDay(Date endWorkingDay) {
        this.endWorkingDay = endWorkingDay;
    }

    public Integer getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(Integer cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public List<Talon> getUsedTalons() {
        return usedTalons;
    }


    public List<Talon> getTakenTalons() {
        return takenTalons;
    }

    @Override
    public String toString() {
        return "\nSpecialist{" +super.toString()+
                "specialty=" + specialty +
                ", beginWorkingDay=" + beginWorkingDay +
                ", endWorkingDay=" + endWorkingDay +
                ", cabinetNumber=" + cabinetNumber +
                ", salary=" + salary +
                "} ";
    }
}

