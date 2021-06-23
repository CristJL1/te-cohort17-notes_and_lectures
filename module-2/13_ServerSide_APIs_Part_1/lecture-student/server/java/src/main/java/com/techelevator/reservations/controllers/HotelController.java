package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this is a controller for URL calls to the server
//
// coordinate requests from a client (View) to process data managed by the DAO (Model)
//
// Spring Boot automagically converts JSON to Java objects (deserialize) when receiving a request
//          and Java objects to JSON (serialize) when returning to client

@RestController // this tells the server there are methods in this class to handle URL paths
public class HotelController {

    // define references for any DAOs we are using
    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    // constructor for this class - initialize member data when object of this class is instantiated
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO(); // instantiate a new HotelDAO and assign it to the reference
        this.reservationDAO = new MemoryReservationDAO(hotelDAO); // instantiate a new reservation DAO and assign it to the reference
    }                                                             // since the ReservationDAO needs a HotelDAO, we sent it one

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // a controller method to handle a URL path given to the server
    // @RequestMapping - annotation to identify the path and HTTP request this method will handle
    @RequestMapping(path = "/hotels", method = RequestMethod.GET) // handle the /hotels path for an HTTP GET request
    public List<Hotel> list() { // return a list of Hotel objects and receive no parameters
        System.out.println("Hello from the list() in the Controller");
        return hotelDAO.list(); // return whatever the hotelDAO list() sends us back
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */

    // handle the path: /hotels/id - id ia a variable in the URL path
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET) // {id} - a path variable is expected
    public Hotel get(@PathVariable int id) { // @PathVariable says get the id from the path
                                             // and store it in an int called id
        System.out.println("/hotel/" + id + " path received from the server"); // log how you got here and what was sent
        return hotelDAO.get(id); // return whatever the hotelDAO get(id) method returns
    }

    // write a controller to add a reservation to our Resource
    //      using the path: /hotels/id/reservations = /hotels/1/reservations will add a reservation for hotel id 1 to our resource
    //
    // the data for reservation to be added is expected to be a Reservation object in the body of an HTTP POST
    // so...we need the Reservation POJO in this project - we have it
    //      we need a method in the ReservationDAO to add a Reservation
    //              we have one:     Reservation create(Reservation reservation, int hotelID);
    // we need to use @PathVariable to get the hotel id from the path
    // we need to use @RequestBody to get the Reservation object out of the request body

    @RequestMapping (path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@PathVariable("id") int hotelId, @RequestBody Reservation aReservation) { // get the path variable called id and store it in the int called hotelId
                                                                                                    // instantiate a Reservation from the request body
        System.out.println("/hotel/" + hotelId + "/reservations received for an HTTP POST from server");

        // instantiate a new reservation from the one returned from the ReservationDAO
        Reservation theReservation = reservationDAO.create(aReservation, hotelId);

        return theReservation; // return the reservation from the DAO
    }

    //write a controller to return a specific reservation for a hotel
    // CANNOT DO THIS - THERE IS NOT DAO METHOD TO HANDLE IT

    // write a controller to return all reservations for a hotel
    // reservation DAO method: List<Reservation> findByHotel(int hotelID);
    // path: /hotels/{id}/reservations
    //          this is the same path for adding a Reservation
    //          it's OK, because this time the path is for an HTTP GET
    //
    // the path/HTTP Request combination must be unique within the controller

    @RequestMapping (path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> findByHotel(@PathVariable("id") int hotelId) {
        System.out.println("/hotel/" + hotelId + "/reservations received for an HTTP GET from server");
        return reservationDAO.findByHotel(hotelId);
    }


    // write a controller to return all reservations
    // Path: /reservations

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> findAllReservations() {
        return reservationDAO.findAll();
    }

}
