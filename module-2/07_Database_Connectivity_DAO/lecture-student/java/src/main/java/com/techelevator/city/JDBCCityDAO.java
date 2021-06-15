package com.techelevator.city; // same package as the POJO and the DAO interface

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

// concrete class for the DAO - implements the methods required by the interface
//								and any additional methods that might be necessary


// name tells us the source of the data (JDBC), the name of the table (City), and that it's the DAO
public class JDBCCityDAO implements CityDAO {

	// define a reference to the JdbcTemplate object we will use to access Spring DAO Framework
	private JdbcTemplate jdbcTemplate;

	// constructor for the class which takes the data source as a parameter
	// dataSource will be provided when this DAO is instantiated (from application program)
	public JDBCCityDAO(DataSource dataSource) {
		// instantiate a JdbcTemplate object with the dataSource given and assign it to our reference
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Save the given City object to the database
	@Override // Optional - asks the compiler to be sure we are implementing the method the DAO interface is expecting
	// return nothing and receives a City object
	public void save(City newCity) {
		// define a string for the SQL statement we want to run using Spring DAO framework
		// coding ? in the SQL statement where we want to provide values from variables
		//		when we run the statement
		// the number of ? must match the number of values expected by the SQL statement
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)"; // ? - indicates a value from a variable when run

		newCity.setId(getNextCityId()); // set the id of the City object passed to the next ID the database manager will assign
										// we need to know the id of the new row in the table

		// use our Spring DAO object to execute the SQL statement
		// .update() is used for INSERT, UPDATE, DELETE SQL statements
		//		SQL statement, values-each-?-in-statement
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), // replace the 1st ? with the Id in the City object
										  newCity.getName(), // replace the 2nd ? with the name in the City object
										  newCity.getCountryCode(), // replace the 3rd ? with the countryCode in the City object
										  newCity.getDistrict(), // replace the 4th ? with the district in the City object
										  newCity.getPopulation()); // replace the 5th ? with the population in the City object
	}

	// Return a City object from the database for the id specified
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	// Return all the City objects from the database for the given countryCode
	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	// Return all the City objects from the database for the given district (state)
	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	// Update the City data in the database using the City object passed
	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	// Delete the city data in the database for the given id
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	//--------------------------------------------------------------------------------------------------------------
	// Helper Methods (not required by DAO) - do some common processing we need to get done
	//--------------------------------------------------------------------------------------------------------------



	// Get the next City id from the database manager
	//		because id is defined as a serial value - meaning the database manager will generate a unique value
	// since we need to know what id the database is going to generate for the new row because we want to store in the
	//		City object passed to us - we need to retrieve from the database manager before we do the insert
	//
	// PostgreSql uses sequence objects to keep track of serial values
	// we can ask the sequence object to give us it's next value by selecting nextval('seq-object-name')
	private long getNextCityId() {
		// a select SQL statement is expected to return a result of 0 or more rows
		// we need to store to the result the select in an SqlRowSet object when using the Spring DAO Framework


		//get the next value from sequence object called seq_city_id
		// and store it in an SqlRowSet object called nextIdResult
		// we use the .queryForRowSet() when running a select because it returns a RowSet
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");


		if(nextIdResult.next()) { 			    // if there is a row in the SqlRowSet object
			return nextIdResult.getLong(1);  // get the serial value from it as a long and return it
											   // getLong(1) - get the first column as a long
		} else {							   // if there is no row in the SqlRowObject (because we are expecting one)
			throw new RuntimeException("Something went wrong while getting an id for the new city"); // throw an exception
		}
	}

	// Return a City object from the data retrieved from the database
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
