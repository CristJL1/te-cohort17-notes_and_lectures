package com.techelevator;

import com.techelevator.pet.JDBCPetDAO;
import com.techelevator.pet.Pet;
import com.techelevator.pet.PetDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class ReviewDayApplicationProgram {

	public static void main(String[] args) {

		System.out.println("\n"+"-".repeat(20)+"Welcome to the Module 2, Day 10 Review Application" + "-".repeat(20)+"\n");

		// Define and instantiate a data source object for use by the DAO we are using
		BasicDataSource reviewDataSource = new BasicDataSource();
		reviewDataSource.setUrl("jdbc:postgresql://localhost:5432/review10");  // Set connection string for database
		reviewDataSource.setUsername("postgres");                              // Set owner of database
		reviewDataSource.setPassword("postgres1");                             // Set password for owner of database


		PetDAO thePetTables = new JDBCPetDAO(reviewDataSource); // define an object to interact with the Pet DAO methods

		// call the PetDAO to get all the pets
		List<Pet> thePets = thePetTables.getAllPets();


		//display all the pets we got from the Pet database
		for (Pet aPet: thePets) {

			System.out.println("-".repeat(20) + "\n" + aPet);

		}

	}
}
