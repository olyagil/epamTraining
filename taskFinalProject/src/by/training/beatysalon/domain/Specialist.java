package by.training.beatysalon.domain;

import java.util.Date;
import java.util.List;

public class Specialist extends UserInfo {

    private Specialty specialty;
    private Date employmentDate;
    private Integer cabinetNumber;
    private Double salary;

    private List<Talon> usedTalons;
    private List<Talon> takenTalons;

    @Override
    public String toString() {
        return "Specialist{" + super.toString() +
                "specialty=" + specialty +
                ", employmentDate=" + employmentDate +
                ", cabinetNumber=" + cabinetNumber +
                ", salary=" + salary +
                ", usedTalons=" + usedTalons +
                ", takenTalons=" + takenTalons +
                "} ";
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Integer getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(Integer cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

