package by.training.beautysalon.entity;

import by.training.beautysalon.entity.enumeration.Specialty;

import java.sql.Date;

public class Employee extends User {

    private Specialty specialty;
    private Date employmentDate;
    private Integer cabinetNumber;
    private Double salary;


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

