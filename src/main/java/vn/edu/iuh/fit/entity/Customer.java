package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "CusID")
    private long cus_id;
    @Column(name = "CusName", columnDefinition = "varchar(50)")
    private String cus_name;
    @Column(name = "Email", columnDefinition = "varchar(200)")
    private String email;
    @Column(name = "Phone", columnDefinition = "varchar(20)")
    private String phone;
    @Column(name = "DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "BankCode")
    private Bank bank;

    public Customer() {
    }

    public Customer(long cus_id, String cus_name, String email, String phone, LocalDate dob, Bank bank) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.bank = bank;
    }

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", bank=" + bank +
                '}';
    }
}
