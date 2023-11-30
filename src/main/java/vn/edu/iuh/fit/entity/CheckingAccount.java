package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "checkingaccount")
public class CheckingAccount {
    @Id
    @OneToOne
    @JoinColumn(name = "AccountID")
    private Account account;
    @Column(name = "MinBalance")
    private double minimum_balance;

    public CheckingAccount() {
    }

    public CheckingAccount(Account account, double minimum_balance) {
        this.account = account;
        this.minimum_balance = minimum_balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getMinimum_balance() {
        return minimum_balance;
    }

    public void setMinimum_balance(double minimum_balance) {
        this.minimum_balance = minimum_balance;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "account=" + account +
                ", minimum_balance=" + minimum_balance +
                '}';
    }
}
