package com.Starkindustries.SpringDataJpaMark1.Mappings.OneToOneMapping;

import com.Starkindustries.SpringDataJpaMark1.Mappings.Request.EmployeeRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "deptId")
    private Department department;


    public Employee(int empId, String name, Department department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name){
        this.name=name;
    }

    public Employee(EmployeeRequest employeeRequest){
        this.name=employeeRequest.getName();
    }

    public Employee(){

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
