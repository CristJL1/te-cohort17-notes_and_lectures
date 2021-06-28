package com.techelevator.controller;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * Controller to authenticate users.
 */

@RestController // tell the server there are methods in here to handle URL paths it might get
public class DepartmentController {

// define a reference to the department DAO so we can handle API calls to get Department data
DepartmentDAO theDeptData;

// constructor for the controller class to receive the DAO object(s) and assign it to our reference(s)
// Spring will Dependency Inject (DI) the DAO object when it instantiates the controller
    // so we don't have to know or care about what the concrete class is actually called
        // (we are loosely coupled to the concrete class for the DAO)

    public DepartmentController(DepartmentDAO theDeptMethod) {
        theDeptData = theDeptMethod;
    }

// write controller to handle an API class to get all the departments
//
// HTTP Request: Get
// path: /departments - no path variable or query string variables needed
//
// to get data use DepartmentDAO method: public List<Department> getAllDepartments();

    @RequestMapping (path = "/department", method = RequestMethod.GET)
    public List<Department> getTheDepartments () {
        logAPICall("GET - /department"); // log the request we received
        // List<Department> theDepartments = new ArrayList(); // hold the result to be returned
        // theDepartments = theDeptData.getAllDepartments();
        // return theDepartments;                            // same result as below, but takes more steps

        return theDeptData.getAllDepartments();
    }

// write a controller to add a new Department to the Department resource
//
//      HTTP request: POST
//      path: /department
//
//      DAO method to use: public Department createDepartment(Department newDepartment);

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping (path = "/department", method = RequestMethod.POST)
    // get the data from the request body and store it in a Department object
    public Department addNewDepartment(@RequestBody Department newDepartment) {
        logAPICall("POST - /department");
        return theDeptData.createDepartment(newDepartment);
    }


	
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}


