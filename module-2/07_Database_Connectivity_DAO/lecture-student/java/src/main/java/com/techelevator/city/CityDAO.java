package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	// Save the given City object to the database
	public void save(City newCity);

	// Return a City object from the database for the id specified
	public City findCityById(long id);

	// Return all the City objects from the database for the given countryCode
	public List<City> findCityByCountryCode(String countryCode);

	// Return all the City objects from the database for the given district (state)
	public List<City> findCityByDistrict(String district);

	// Update the City data in the database using the City object passed
	public void update(City city);

	// Delete the city data in the database for the given id
	public void delete(long id);
}
