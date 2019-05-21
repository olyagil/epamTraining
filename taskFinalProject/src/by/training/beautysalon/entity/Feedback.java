package by.training.beautysalon.entity;

import java.sql.Date;

public class Feedback extends Entity {

    private User client;
    private Employee employee;
    private Date date;
    private String review;

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "\nFeedback{" + super.toString() +
                "client=" + client +
                ", employee=" + employee +
                ", date=" + date +
                ", review='" + review + '\'' +
                "} ";
    }
}
