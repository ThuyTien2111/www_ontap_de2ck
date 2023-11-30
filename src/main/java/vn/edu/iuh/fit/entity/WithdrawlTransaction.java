package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "withdrawltrans")
public class WithdrawlTransaction {
    @Id
    @OneToOne
    @JoinColumn(name = "TransID")
    private Transaction transaction;
    @Column(name ="HaveInvoice")
    private boolean have_invoice;

    public WithdrawlTransaction() {
    }

    public WithdrawlTransaction(Transaction transaction, boolean have_invoice) {
        this.transaction = transaction;
        this.have_invoice = have_invoice;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public boolean isHave_invoice() {
        return have_invoice;
    }

    public void setHave_invoice(boolean have_invoice) {
        this.have_invoice = have_invoice;
    }

    @Override
    public String toString() {
        return "WithdrawlTransaction{" +
                "transaction=" + transaction +
                ", have_invoice=" + have_invoice +
                '}';
    }
}
