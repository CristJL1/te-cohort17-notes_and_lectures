package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

public class ReviewDayApplicationProgram {

	public static void main(String[] args) {

		System.out.println("\n"+"-".repeat(20)+"Welcome to the Module 2, Day 10 Review Application" + "-".repeat(20)+"\n");

		// Define and instantiate a data source object for use by the DAO we are using
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/review10");  // Set connection string for database
		worldDataSource.setUsername("postgres");                              // Set owner of database
		worldDataSource.setPassword("postgres1");                             // Set password for owner of database
		

	}
}
