package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="transfertrans")
public class TransferTransaction {
    @Id
    @OneToOne
    @JoinColumn(name = "TransID")
    private Transaction transaction;
    @ManyToOne
    @JoinColumn(name = "ToAccountID")
    private Account account;
    @Column(name = "Message", columnDefinition = "varchar(500)")
    private String message;

    public TransferTransaction() {
    }

    public TransferTransaction(Transaction transaction, Account account, String message) {
        this.transaction = transaction;
        this.account = account;
        this.message = message;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TransferTransaction{" +
                "transaction=" + transaction +
                ", account=" + account +
                ", message='" + message + '\'' +
                '}';
    }
}
