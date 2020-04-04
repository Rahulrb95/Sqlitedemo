package com.example.prosoltestdemo;

public class UserModel {

    private String empName;
    private String empPhone;
    private String empEmail;
    private String empAddress;

    public UserModel() {
    }

    public UserModel(String empName, String empPhone, String empEmail, String empAddress) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }
}
