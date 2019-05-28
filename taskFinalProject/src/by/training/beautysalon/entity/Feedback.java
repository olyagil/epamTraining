package by.training.beautysalon.entity;

import java.sql.Date;

public class Feedback extends Entity {

    private User client;
    private Employee employee;
    private Date date;
    private String review;

    public Feedback() {
    }

    public Feedback(User client, Employee employee, Date date, String review) {
        this.client = client;
        this.employee = employee;
        this.date = date;
        this.review = review;
    }

    public Feedback(Integer id, User client, Employee employee,
                    Date date, String review) {
        super(id);
        this.client = client;
        this.employee = employee;
        this.date = date;
        this.review = review;
    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Feedback feedback = (Feedback) o;

        if (getClient() != null ? !getClient().equals(feedback.getClient()) : feedback.getClient() != null) {
            return false;
        }
        if (getEmployee() != null ? !getEmployee().equals(feedback.getEmployee()) : feedback.getEmployee() != null) {
            return false;
        }
        if (getDate() != null ? !getDate().equals(feedback.getDate()) : feedback.getDate() != null) {
            return false;
        }
        return getReview() != null ? getReview().equals(feedback.getReview()) : feedback.getReview() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getReview() != null ? getReview().hashCode() : 0);
        return result;
    }
}
