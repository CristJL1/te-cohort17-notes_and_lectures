package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String         BASE_URL;
  private final RestTemplate   theAPI = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation - given a String delimiter value with the Reservation info
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
    // it's always a good idea to make sure we received an object when we are called
    //    to avoid a NullPointerException when we use the object

    if (newReservation == null) {
      System.out.println("Missing Reservation Information - Cannot continue attempting to add new Reservation"); // may want to add this to the ConsoleService
      return  null;
    }

    // now that we know we have information for a new Reservation, let's make one and add it to the server resource
    // instantiate a Reservation object using the helper method
    Reservation aReservation = makeReservation(newReservation);

    // we need to do a POST to add to a server resource
    // an HTTP POST requires headers to describe the data being sent
    //              and the data to be added in the body of the request

    // the HttpHeaders class will create headers for an HTTP request

    HttpHeaders theHeaders = new HttpHeaders(); // define an object to hold the header information for the request

    theHeaders.setContentType(MediaType.APPLICATION_JSON); // include in the headers that we are sending JSON data
                                                           // MediaType is a group of valid content types for headers

    // we need to create  a properly formatted request object for the API call
    // the HttpEntity calss will create a properly formatted rerquest for use

    HttpEntity anEntity = new HttpEntity(aReservation, theHeaders); // create the response as an HttpEntity object
                                                                    // with data and headers to be packaged into the request

    // now that we have a properly formatted request, we can call the server using our RestTemplate object
    // the postForObject() RestTemplate method will issue an HTTP Post to the URL and return an object from the call
    // the API should be adding the primary key to the object (just like in DAO and Relational Data Base)
    //      so we want the object with the API assigned primary key so we can return it
    //                    postForObject(            URL              , request ,  class-of-object-to-be-returned)
    aReservation = theAPI.postForObject(BASE_URL + "reservations", anEntity, Reservation.class);





    return aReservation; // return the Reservation object created from the String passed to us
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param newReservationString
   * @return
   */
  public Reservation updateReservation(String newReservationString) {
    // let's be sure we have data passed to us

    if (newReservationString == null) {
      System.out.println("Unable to update reservation, no new data sent");
      return null;
    }

    // we need to do an HTTP PUT to update a server resource
    // an HTTP PUT requires headers to describe the data being sent and the date to be update in body of the request

    // create a reservation object to send to the API
    Reservation aReservation =  makeReservation(newReservationString);

    //create the request headers with the type of data we are sending

    HttpHeaders theHeaders = new HttpHeaders();

    theHeaders.setContentType(MediaType.APPLICATION_JSON);

    // create a properly formatted request with the data to send and the headers

    HttpEntity aRequest = new HttpEntity(aReservation, theHeaders);

    // call the API using a request and receiving nothing, since by standard, nothing is returned from a PUT
    // path for API update: reservations/:id - we need to add the key for resource to be updated

    theAPI.put(BASE_URL + "reservations/" + aReservation.getId(), aRequest);

    return aReservation; // return the updated Reservation object
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    // the path to the API for a delete is: reservations/:id - :id is the id to delete
    theAPI.delete(BASE_URL + "reservations/" + id);
  }

  /******************************** */
  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */
  /******************************** */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    // it's good practice to always check for exceptions from your RestTemplate calls
    //
    // only 2 exceptions that are thrown by the RestTemplate
    //
    // RestClientResponseException - means there was an error in the HTTP request
    //                               the HTTP status code and message text are available in the Exception object
    //
    // ResourceAccessException - means there is an error getting to the server
    //                           which means there is no HTTP status code since it's generated by the server
    //                           but there is message text available in the Exception object
    //
    try {
      hotels = theAPI.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {    // if there is an HTTP request error...
      // handles request error exceptions thrown by rest template and contains status codes
      // getRawStatusCode() method in the Exception object returns the status code (401,404, etc.) from the HTTP request
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText()); // display the status code and message
                                                                                         // using the ConsoleService
    } catch (ResourceAccessException ex) {  // if there is an error getting to the server
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage()); // display the message
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = theAPI.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = theAPI.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = theAPI.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = theAPI.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  // helper method to instantiate and return a Reservation object from a comma delimited String containing:
  //
  //      Hotel ID, Full Name, Check In Date, Check Out Date, Number of Guests
  // ex:      1     John Smith      10/10/20      10/14/20          2
  //
  private Reservation makeReservation(String newReservationString) {
    String[] parsed = newReservationString.split(","); // split the parts of the String into it's parts based on commas (,)

    // invalid input if exactly 6 values are not provided in the String
    if (parsed.length < 5 || parsed.length > 6) {   // if there are less than 5 or more than 6 elements in the parsed array
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1); // Java provided method to copy an array
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    // instantiate a new reservation object using the values in parsed array and return it
    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
