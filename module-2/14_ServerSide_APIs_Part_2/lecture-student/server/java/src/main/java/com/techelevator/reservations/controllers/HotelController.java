package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO       theHotelResource;
    private ReservationDAO theReservationResource;

    // constructor is accepting the DAO objects as parameters, rather than instantiate them itself
    // where do the objects come from for the constructor? We ddi not instantiate them and send to ctor?
    //      who did instantiate them and send to ctor?
    //      Spring Dependency Injection did it for us!
    // Spring Dependency Injection (DI) automagically instantiates objects and passes them to ctor
    // you must specify the @Component annotation in a class you want to be considered for DI
    // the concrete classes for the DAO must have @component annotation so Spring DI will instantiate them
    //          and pass the new objects to the ctor
    public HotelController(HotelDAO theHotelResource, ReservationDAO theReservationResource) {
        this.theHotelResource       = theHotelResource;
        this.theReservationResource = theReservationResource;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path="/hotels", method=RequestMethod.GET)
    public List<Hotel> list() {
        logAPICall("GET  - /hotels");           // Log path to server log
        return theHotelResource.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        logAPICall("GET  - /hotels/"+ id);          // Log path to server log
        return theHotelResource.get(id);
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservations() {
        logAPICall("GET  - /reservations");         // Log path to server log
        return theReservationResource.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @exception ReservationNotFoundException if reservation does not exist.
     * @return a single reservation
     */
    @RequestMapping(path="reservations/{id}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        logAPICall("GET  - /reservations/" + id);   // Log path to server log
        return theReservationResource.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelID
     * @return all reservations for a given hotel
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelID) throws HotelNotFoundException {
        logAPICall("GET  - /hotels/" + hotelID + "/reservations");   // Log path to server log
        return theReservationResource.findByHotel(hotelID);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     * @param hotelID
     */

    // if you want the server to use any validation annotations you have in the POJO:
    //
    //      1. include @valid in the method parameter list before the @RequestBody
    @ResponseStatus(HttpStatus.CREATED) // set the HTTP status code when the method terminates
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(  @Valid
                                        @RequestBody Reservation reservation
                                       ,@PathVariable("id") int hotelID)
            throws HotelNotFoundException { // throws says "I know this exception might happen"
        logAPICall("POST - /hotels/" + hotelID + "/reservations");   // Log path to server log
        return theReservationResource.create(reservation, hotelID);
    }

    /**
     * update an existing reservation
     *
     * /reservations/{id} = standard RESTful path got an update
     *
     * handle an HTTP PUT for an update
     *
     * @param aReservation - from Request Body
     * @param id          - from Path Variable
     * @return the updated reservation
     */

    @RequestMapping (path = "/reservations/{id}", method = RequestMethod.PUT)
    public Reservation updateReservation (@Valid @RequestBody Reservation aReservation, @PathVariable int id) throws ReservationNotFoundException {

        // call the DAO to update the resource and return the updated reservation from the DAO
        return theReservationResource.update(aReservation, id);
    }

    /**
     * delete an existing reservation
     *
     * /reservations/{id} = standard RESTful path for a delete
     *
     * @param id - from PathVariable
     *
     * nothing to return
     */

    @ResponseStatus(HttpStatus.NO_CONTENT) // return the NO_CONTENT status after the delete
    @RequestMapping (path = "/reservations/{id}", method = RequestMethod.DELETE)
    public void deleteReservation (@PathVariable int id) throws ReservationNotFoundException {
        theReservationResource.delete(id);
    }


    /**
     * /hotels/filter?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path="/hotels/filter", method=RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state
                                           ,@RequestParam(required = false) String city) {

        // Log path to server log with parameters omitting optional parameters if missing
        logAPICall("GET  - /hotels/filter?state=" + state + ((city != null) ? "&city=" + city : ""));

        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = theHotelResource.list() ;   // Get all the hotels from the Hotel resource
        // return hotels that match state
        for (Hotel hotel : hotels) {

            // if city was passed we don't care about the state filter
            if (city != null) {
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            }
        }
        return filteredHotels;
    }

    /****************************************************************************************************
     * Helper method to Write a message with a time stamp to the server log\
     *
     *  @param message
     ***************************************************************************************************/
    public void logAPICall(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
        String timeNow = now.format(formatter);
        System.out.println(timeNow + "-" + message);
    }
}
