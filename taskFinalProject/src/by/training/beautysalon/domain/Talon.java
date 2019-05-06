package by.training.beautysalon.domain;

public class Talon extends Bill {

   private UserInfo client;
   private Bill bill;

    public UserInfo getClient() {
        return client;
    }

    public void setClient(UserInfo client) {
        this.client = client;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "\nTalon{" +
                "client=" + client +
                ", bill=" + bill +
                "} " + super.toString();
    }
}
