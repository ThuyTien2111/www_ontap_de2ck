package vn.edu.iuh.fit.convert;

public class ManagerForm {
    private String manID;
    private String name;
    private String phone;
    private String status;

    public ManagerForm() {
    }

    public ManagerForm(String manID, String name, String phone, String status) {
        this.manID = manID;
        this.name = name;
        this.phone = phone;
        this.status = status;
    }

    public String getManID() {
        return manID;
    }

    public void setManID(String manID) {
        this.manID = manID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManagerForm{" +
                "manID='" + manID + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
