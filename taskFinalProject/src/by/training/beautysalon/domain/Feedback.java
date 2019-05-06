package by.training.beautysalon.domain;

import java.sql.Date;

public class Feedback extends Entity {

    private UserInfo client;
    private Specialist specialist;
    private Date date;
    private String review;

    public UserInfo getClient() {
        return client;
    }

    public void setClient(UserInfo client) {
        this.client = client;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
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
                ", specialist=" + specialist +
                ", date=" + date +
                ", review='" + review + '\'' +
                "} ";
    }
}
