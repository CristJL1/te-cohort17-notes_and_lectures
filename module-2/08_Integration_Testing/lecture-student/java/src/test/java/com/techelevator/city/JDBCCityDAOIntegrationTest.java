package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // list the tests in alphabetical order
public class JDBCCityDAOIntegrationTest {

	//this will allow database access using DAO for the City table

	// define constants for use in creating new rows for testing in the table
	private static final String TEST_COUNTRY = "XYZ"; // assuming that countrycode XYZ is not already in any table

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource; // define a reference to the datasource
															// datasource instantiated and assigned to the test
	private JDBCCityDAO dao; 	// define a reference to the class containing the methods to be tested
								// this will be instantiated and assigned during testing

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass // do this when this class is instantiated = stuff to be done ONCE that every method needs
	public static void setupDataSource() { // JUnit test methods always return void and accept no parameters
		dataSource = new SingleConnectionDataSource(); // instantiate the datasource and assign to reference
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world"); // datasource connection string
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false); // tell the database we will control commit/rollback
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass // do this ONCE before the class is destroyed - end of testing
	public static void closeDataSource() throws SQLException {
		dataSource.destroy(); // close the datasource to release resources and avoid resource leaks
	}

	@Before // do this before each test is run - typically this will set up test data
			// avoid using actual data from database in your testing - it could change from test to test
			// test should be repeatable - if the data changes from one test session to another
			//			the repeatability and reliability is compromised
			// you should always add data to a database for testing that you know is not already in the database
			//			and remove it when you are done testing
	public void setup() {
		// since a city is dependent on a country
		// will add a test country to our database that we KNOW is not already in the database
		//			for use with our test cities

		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
				"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";

		// we want to be sure we have a "clean" jdbcTemplate object so we define a new one for each test
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// run the insert with the TEST_COUNTRY we setup earlier that is not already in the country table
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY); // run the insert with the TEST_COUNTRY we setup earlier that is not already in the country table

		// instantiate and assign a fresh DAO with the methods we are testing for every test
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback(); // undo any changes made to the data during the test
	}

	@Test // every test must start with @Test or JUnit doesn't see it
	// each test is in a separate JUnit method
	// JUnit methods return void, accept no parameters, and should have verbose, meaningful names
	public void save_new_city_and_read_it_back() throws SQLException {
		// when creating a test:
		// 		arrange - set up any test data required for the test
		//		act - run the method with the test data you arranged and get the result
		//		assert - verify the result is what was expected
		//
		//		any one of these steps may require multiple statements or be combined into a single statement
		//
		// arrange a City object to use in the test
		// since the primary key of City is a serial value, we know that this row is not already in the table
		//			the database manager will generate a unique value for the primary key
		// note: use of an existing country code (USA) is not necessarily a good idea
		//			it would be safer to use our TEST_COUNTRY code instead of the existing country code "USA"

		// when adding an object to a table where the primary key is generated
		// we do not provide a primary key in the object we are saving in the database
		// in this case, the City id is generated so we don't provide it in the object
		// the DAO method should set the primary key (id) in the object as part of it's processing

		// create a test City object using a helper method - getCity()
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);

		// act - call the save method with the test city to add it to the table
		dao.save(theCity);

		// get a City object from the City table for the id of the City we just saved
		City savedCity = dao.findCityById(theCity.getId());

		// in the above line of code we are using a method, findCityById(), in the DAO we are testing
		// this may be considered a bad practice in some coding environments
		//		and OK in others IF you have tested that method successfully before you use it

		// the reason that some consider it bad practice is this test is not independent of processing as it should be
		// in this case if fineCityById() is incorrect the results of our test are not reliable

		// if we did not use the method findCityById() we would have written a Helper method
		//		to go to the database with a SELECT, mapped the result to a City object and returned it

		// assert - verify the City object we got from the data in the table matches the City Object we saved
		assertNotEquals(null, theCity.getId()); // verify that a city object we saved got an id assigned
		assertCitiesAreEqual(theCity, savedCity); // verify the City object returned from the database matches
														// the City object we sent using a Helper method
												  // assertCitiesAreEqual() is NOT a JUnit test
												  		// it's a helper method we wrote for testing
	}

	// test when multiple rows may be returned from a DAO method
	// using 2 tests - one if only a single row is in the table and one if multiple
	// sometimes multiple tests are required to fully test a method
	@Test
	public void returns_cities_by_country_code() {
		// arrange - define a test City with our primary key (id) using our TEST_COUNTRY
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// act - add one new object to the database
		dao.save(theCity);
		// get the result of the act step by retrieving only rows for our test country
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		// assert - verify results
		assertNotNull(results);			// verify - did we get something back from the method?
		assertEquals(1, results.size()); // verify - only one row came back (we only added one)
		City savedCity = results.get(0); // get the first object in the list
		assertCitiesAreEqual(theCity, savedCity); // verify - the object we got from the list matches the one we sent
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		// arrange - add multiple objects to the City table
		// instantiate new objects and calling the method all in one statement
		// we are using the TEST_COUNTRY so we know only the rows we add have that value
		// arrange and act are in the same statement
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		// retrieve the objects added for the TEST_COUNTRY (there should be only 2)
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);


		assertNotNull(results); // verify something was returned (at least one row in the table)
		assertEquals(2, results.size()); // verify exactly 2 rows were returned because we only added 2 rows

		// we did not test for conditions already tested by other test methods
		// we did not check to see if the 2 objects we retrieved matched the 2 objects we sent
		// we COULDN'T since the object we sent were created in the call to the method and no longer exist
		// if you want to test that the objects retrieved match the objects sent - instantiate separate objects 
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	/****************************************************************************************************************
	 * Helper methods used in the tests to provide common processing that needs to get done
	 ****************************************************************************************************************/

	// create a new City object for testing using values passed for all columns except the primary key

	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	// assert that each value in the objects passed are equal

	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
