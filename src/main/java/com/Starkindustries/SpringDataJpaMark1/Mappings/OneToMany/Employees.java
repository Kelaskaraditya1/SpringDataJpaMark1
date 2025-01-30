package com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "empName")
    private String empName;


    public Employees(int empId, String empName){
        this.empId=empId;
        this.empName=empName;
    }

    public Employees(String empName){
        this.empName=empName;
    }

    public Employees(){

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }
}
