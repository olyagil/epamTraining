package by.training.beautysalon.entity;

import java.sql.Timestamp;

public class Talon extends Entity {

    private User client;
    private Service service;
    private Employee employee;
    private Timestamp receptionDate;
    private boolean status;

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Timestamp receptionDate) {
        this.receptionDate = receptionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
