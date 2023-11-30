package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "ManagerID")
    private long man_id;
    @Column(name = "ManagerName", columnDefinition = "varchar(50)")
    private String man_name;
    @Column(name = "Phone", columnDefinition = "varchar(20)")
    private String phone;
    @Column(name = "Status", columnDefinition = "tinyint(2)")
    private int status;

    public Manager(String man_name, String phone) {
        this.man_name = man_name;
        this.phone = phone;
    }


    public Manager() {
    }

    public Manager(long man_id, String man_name, String phone, int status) {
        this.man_id = man_id;
        this.man_name = man_name;
        this.phone = phone;
        this.status = status;
    }

    public long getMan_id() {
        return man_id;
    }

    public void setMan_id(long man_id) {
        this.man_id = man_id;
    }

    public String getMan_name() {
        return man_name;
    }

    public void setMan_name(String man_name) {
        this.man_name = man_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "man_id=" + man_id +
                ", man_name='" + man_name + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
