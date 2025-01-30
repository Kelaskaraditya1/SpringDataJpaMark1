package com.Starkindustries.SpringDataJpaMark1.Mappings.Request;

import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany.Projects;

import java.util.List;

public class ProjectRequest {

    private String empName;

    private List<String> projectsList;

    public ProjectRequest(String empName,List<String> projectsList){
        this.empName=empName;
        this.projectsList=projectsList;
    }

    public ProjectRequest(String empName){
        this.empName=empName;
    }

    public ProjectRequest(List<String> projectsList){
        this.projectsList=projectsList;
    }

    public ProjectRequest(){

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<String> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<String> projectsList) {
        this.projectsList = projectsList;
    }

    @Override
    public String toString() {
        return "ProjectRequest{" +
                "empName='" + empName + '\'' +
                ", projectsList=" + projectsList +
                '}';
    }
}
