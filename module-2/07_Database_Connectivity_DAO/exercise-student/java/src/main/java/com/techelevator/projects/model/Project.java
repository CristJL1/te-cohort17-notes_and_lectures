package com.techelevator.projects.model;

import java.sql.Date;
import java.time.LocalDate;

public class Project {
	// TODO: Place code to describe the columns in the table row here

    private Long project_id;

    private String name;

    private Date from_date;

    private Date to_date;

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        return "Project - " + name;
    }
}
