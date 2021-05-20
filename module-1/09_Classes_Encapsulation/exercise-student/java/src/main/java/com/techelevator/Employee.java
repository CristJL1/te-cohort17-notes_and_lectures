package com.techelevator;

public class Employee {

    private int employeeId;

    private String firstName;

    private  String lastName;

    private String fullName;

    private String department;

    private double annualSalary;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {

        fullName = (lastName + ", " + firstName);

        return fullName;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }


    public void raiseSalary (double percent) {

        annualSalary = annualSalary + (annualSalary * (percent/100));


    }


    public Employee () {

        employeeId = 0;
        firstName = null;
        lastName = null;
        fullName = null;
        department = null;
        annualSalary = 0.0;

    }

    public Employee (int idNumber, String first, String last, double salary) {

        employeeId = idNumber;
        firstName = first;
        lastName = last;
        annualSalary = salary;
        department = null;
        fullName = last + ", " + first;


    }






}
