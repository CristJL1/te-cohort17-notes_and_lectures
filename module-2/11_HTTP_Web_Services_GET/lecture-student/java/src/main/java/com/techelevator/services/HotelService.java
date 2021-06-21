package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    // RestTemplate is a framework for making and managing API calls

    private final String API_BASE_URL; // hold the base URL for the server
    private RestTemplate restTemplate = new RestTemplate(); // define an instantiate a RestTemplate object

    // constructor for the class - receives the base URL for the server and assigns it to our data member for holding it
    public HotelService(String apiURL) {

        API_BASE_URL = apiURL;
    }

    // return all the hotels from the API server - hotels path - return all the hotels from the server
    public Hotel[] listHotels() {
        // call the API server with the hotels path and have it return a list of hotel objects
        // getForObject() methods for the RestTemplate class receives a URL and the type of object you want returned
        // Hotel[].class - we want an array of Hotel objects returned and Hotel is a class
        // RestTemplate AUTOMAGICALLY creates objects of the class specified using the standard setters
        //      expects the data member names in the POJO to match the JSON attribute names you want
        //      if they don't no data is put in the attributes of the object (null or 0)
        return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
    }

    public Review[] listReviews() {

        return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    // get information for the specific hotelID passed - path: hotels/:id
    public Hotel getHotelById(int id) {

        return restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
    }

    // get all the reviews from the API for a particular hotel - path: hotels/:id/reviews
    public Review[] getReviewsByHotelId(int hotelID) {

    // construct the URL as a String with the value for the hotelID in the proper place
    // concatenate the value passed in the URL when you call the API
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        return null;
    }

    public City getWithCustomQuery(){

        return null;
    }

}
