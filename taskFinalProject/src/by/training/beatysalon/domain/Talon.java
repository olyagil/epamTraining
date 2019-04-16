package by.training.beatysalon.domain;

import java.util.Date;

public class Talon extends Entity {

    private Service service;
    private Specialist specialist;
    private Client client;
    private Date receptionDate;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "\nTalon{" +
                "service=" + service +
                ", specialist=" + specialist +
                ", receptionDate=" + receptionDate +
                ", client=" + client +
                "} ";
    }
}
