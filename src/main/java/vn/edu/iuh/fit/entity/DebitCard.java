package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "debit")
public class DebitCard {
    @Id
    @Column(name = "CardNo")
    private String card_no;
    @Column(name = "AmountOwed")
    private double amount_owed;
    @ManyToOne
    @JoinColumn(name = "CusID")
    private Customer customer;

    public DebitCard() {
    }

    public DebitCard(String card_no, double amount_owed, Customer customer) {
        this.card_no = card_no;
        this.amount_owed = amount_owed;
        this.customer = customer;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public double getAmount_owed() {
        return amount_owed;
    }

    public void setAmount_owed(double amount_owed) {
        this.amount_owed = amount_owed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "card_no='" + card_no + '\'' +
                ", amount_owed=" + amount_owed +
                ", customer=" + customer +
                '}';
    }
}
