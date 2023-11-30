package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "atm")
public class ATM {
    @Id
    @Column(name = "AtmID")
    private long atm_id;
    @Column(name = "Location", columnDefinition = "varchar(100)")
    private String location;
    @ManyToOne
    @JoinColumn(name = "ManagerID")
    private Manager manager;
    @ManyToOne
    @JoinColumn(name = "BankCode")
    private Bank bank;

    public ATM() {
    }

    public ATM(long atm_id, String location, Manager manager, Bank bank) {
        this.atm_id = atm_id;
        this.location = location;
        this.manager = manager;
        this.bank = bank;
    }

    public long getAtm_id() {
        return atm_id;
    }

    public void setAtm_id(long atm_id) {
        this.atm_id = atm_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atm_id=" + atm_id +
                ", location='" + location + '\'' +
                ", manager=" + manager +
                ", bank=" + bank +
                '}';
    }
}
