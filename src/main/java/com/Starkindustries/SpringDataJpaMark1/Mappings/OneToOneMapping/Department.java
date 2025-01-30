package com.Starkindustries.SpringDataJpaMark1.Mappings.OneToOneMapping;

import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @Column(name = "department_name")
    private String name;

    public Department(int deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                '}';
    }
}
