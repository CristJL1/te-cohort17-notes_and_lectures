package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

import com.techelevator.rental.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DAOExampleApplicationProgram {

	public static void main(String[] args) {

		// Need to define a data source to the database we want to access
		BasicDataSource worldDataSource = new BasicDataSource();         // simple JDBC data source
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");// connection string
		worldDataSource.setUsername("postgres");                         // owner of the database
		worldDataSource.setPassword("postgres1");                        // password for owner

		// Need to define a data source to the database we want to access
		BasicDataSource dvdstoreDataSource = new BasicDataSource();          // simple JDBC data source
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore"); // connection string
		dvdstoreDataSource.setUsername("postgres");                             // owner of the database
		dvdstoreDataSource.setPassword("postgres1");                            // password for owner

		// Define the DAO we want to use and pass it the datasource we defined
		CityDAO cityTableDao = new JDBCCityDAO(worldDataSource);
		RentalDAO rentalTableDao = new JDBCRentalDAO(dvdstoreDataSource);


		System.out.println("\n"+"-".repeat(40) + "\n" + "City Table Access" + "\n" + "-".repeat(40));

		City smallville = new City();      // define a default City object
		// id was not assigned as it's a serial type in the database and the DAO or database manager will assign it
		smallville.setCountryCode("USA");  // Use the methods of the City object to assign values
		smallville.setDistrict("KS");      //     to the various data members
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		System.out.println("\n  smallville City object defined in the program: " + smallville);
		// we use the dao object we defined to access the methods of the DAO
		cityTableDao.save(smallville);   // use the dao save method to save our City object into the database

		// we use the dao object we defined to access the methods of the DAO
		City theCity = cityTableDao.findCityById(smallville.getId());

		System.out.println("\ntheCity City object retrieved from the database: " + theCity);

		/* Leave this commented out until Frank tells you to de-comment it

		System.out.println("\n"+"-".repeat(40) + "\n" + "Rental Table Access" + "\n" + "-".repeat(40));

		System.out.println("-".repeat(25) + " Get rental id: 15862"+ "-".repeat(25));

		System.out.println(rentalTableDao.getARental(15862));

		System.out.println("\n"+"-".repeat(25) + " Get All Rentals"+ "-".repeat(25));
		for (Rental aRental : (ArrayList<Rental>)rentalTableDao.getAllRentals()) {
			System.out.println(aRental + "\n" + "-".repeat(80));
		}

		System.out.println("\n"+"-".repeat(25) + " Get Rentals for customer # 74"+ "-".repeat(25));
		for (Rental aRental : (ArrayList<Rental>)rentalTableDao.getRentalsForCustomer(74)) {
			System.out.println(aRental + "\n" + "-".repeat(80));
		}

		System.out.println("-".repeat(25) + " Delete rental id: 14"+ "-".repeat(25));

		rentalTableDao.removeRental(14);

		System.out.println("-".repeat(25) + " Delete rentals from  id: 14"+ "-".repeat(25));

		int numberRentalsDeleted = 0;

		LocalDateTime fromDate = LocalDateTime.of(2005,06,01,0,0,0);
		LocalDateTime toDate   = LocalDateTime.of(2005,06,30,23,59,59);

		numberRentalsDeleted = rentalTableDao.removeRentalForDateRange(fromDate,toDate);

		System.out.println(numberRentalsDeleted + " rows deleted for date range " + fromDate + "-" + toDate);
		End of code Frank commented out */



	}  // End of Application Program
}
