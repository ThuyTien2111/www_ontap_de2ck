package vn.edu.iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="bank")
public class Bank {
    @Id
    @Column(name = "BankCode")
    private long bank_code;
    @Column(name = "BankName", columnDefinition = "varchar(100)")
    private String bank_name;
    @Column(name = "Address", columnDefinition = "varchar(200)")
    private String address;

    public Bank() {
    }

    public Bank(long bank_code, String bank_name, String address) {
        this.bank_code = bank_code;
        this.bank_name = bank_name;
        this.address = address;
    }

    public long getBank_code() {
        return bank_code;
    }

    public void setBank_code(long bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank_code=" + bank_code +
                ", bank_name='" + bank_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
