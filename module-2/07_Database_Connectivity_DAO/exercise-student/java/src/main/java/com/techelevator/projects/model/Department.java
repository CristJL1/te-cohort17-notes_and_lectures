package com.techelevator.projects.model;

public class Department {
// TODO: Place code to describe the columns in the table row here

    private Long department_id;

    private String name;

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department - " + name;
    }
}