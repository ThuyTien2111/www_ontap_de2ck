package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "savingaccount")
public class SavingAccount {
    @Id
    @OneToOne
    @JoinColumn(name = "AccountID")
    private Account account;
    @Column(name = "InterestRate")
    private double interest_rate;
    @Column(name = "LimitDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limit_date;

    public SavingAccount() {
    }

    public SavingAccount(Account account, double interest_rate, LocalDate limit_date) {
        this.account = account;
        this.interest_rate = interest_rate;
        this.limit_date = limit_date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public LocalDate getLimit_date() {
        return limit_date;
    }

    public void setLimit_date(LocalDate limit_date) {
        this.limit_date = limit_date;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "account=" + account +
                ", interest_rate=" + interest_rate +
                ", limit_date=" + limit_date +
                '}';
    }
}
