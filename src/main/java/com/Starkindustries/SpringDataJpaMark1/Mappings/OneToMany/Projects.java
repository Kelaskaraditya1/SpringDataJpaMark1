package com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "Projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employees employee;

    public Projects(int pid, String projectName, Employees employee){
        this.pid=pid;
        this.projectName=projectName;
        this.employee=employee;
    }

    public Projects(String projectName, Employees employee){
        this.projectName=projectName;
        this.employee=employee;
    }

    public Projects(){

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return projectName;
    }

    public void setName(String projectName) {
        this.projectName =projectName;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "pid=" + pid +
                ", name='" + projectName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
