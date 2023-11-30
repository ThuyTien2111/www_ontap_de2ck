package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "TransID")
    private long trans_id;
    @Column(name = "AtDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate at_date;
    @Column(name = "Amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "AccountNo")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "AtmID")
    private ATM atm;

    public Transaction() {
    }

    public Transaction(long trans_id, LocalDate at_date, double amount, Account account, ATM atm) {
        this.trans_id = trans_id;
        this.at_date = at_date;
        this.amount = amount;
        this.account = account;
        this.atm = atm;
    }

    public long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(long trans_id) {
        this.trans_id = trans_id;
    }

    public LocalDate getAt_date() {
        return at_date;
    }

    public void setAt_date(LocalDate at_date) {
        this.at_date = at_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trans_id=" + trans_id +
                ", at_date=" + at_date +
                ", amount=" + amount +
                ", account=" + account +
                ", atm=" + atm +
                '}';
    }
}
