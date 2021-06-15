package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExampleApplicationProgram {

	public static void main(String[] args) {

		// Need to define a data source to the database we want to access
		BasicDataSource worldDataSource = new BasicDataSource(); // simple JDBC data source
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world"); // connection string
		worldDataSource.setUsername("postgres");						  // owner of the database
		worldDataSource.setPassword("postgres1");						  // password for the owner

		// define the DAO we want to use and pass it the datasource we defined
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City(); // define a city object
		// id was not assigned as it is a serial type in the database and the database will assign it
		smallville.setCountryCode("USA");  // use the methods of the City object to assign values to the various data members
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		System.out.println("\n  smallville City object defined in the program: " + smallville);

		// we use the DAO object we defined to access the methods of the DAO
		dao.save(smallville); // use the DAO save method to save our City object into the database

		City theCity = dao.findCityById(smallville.getId());

		System.out.println("\ntheCity City object retrieved from the database: " + theCity);

	}
}
