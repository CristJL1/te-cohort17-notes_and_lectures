package com.techelevator.projects.model;

public class Department {
// TODO: Place code to describe the columns in the table row here

    private Long department_id;

    private String department;

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department - " + department;
    }
}