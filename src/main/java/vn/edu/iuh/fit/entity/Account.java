package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "AccountNo", columnDefinition = "varchar(20)")
    private String acc_no;
    @Column(name = "PIN", columnDefinition = "varchar(10)")
    private String pin;
    @Column(name = "Balance")
    private double balance;
    @ManyToOne
    @JoinColumn(name = "CusID")
    private Customer customer;

    public Account() {
    }

    public Account(String acc_no, String pin, double balance, Customer customer) {
        this.acc_no = acc_no;
        this.pin = pin;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_no='" + acc_no + '\'' +
                ", pin='" + pin + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
