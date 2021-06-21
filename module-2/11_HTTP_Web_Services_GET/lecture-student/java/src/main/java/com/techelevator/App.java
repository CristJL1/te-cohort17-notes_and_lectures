package com.techelevator;

import com.techelevator.services.ConsoleService;
import com.techelevator.services.HotelService;

public class App {

    // define a constant to hold the base URL for the server (like defining a datasource for DAO)
    private static final String API_BASE_URL = "http://localhost:3000/";

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;

        // define instances of the services we will be using (like defining JDBCDAO objects for DAOs)
        ConsoleService consoleService = new ConsoleService();
        // pass the base URL for our API server to the service that will be accessing the API
        //      (like instantiating a JDBCDAO object we pass it the datasource)
        HotelService hotelService = new HotelService(API_BASE_URL);

        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu(); // call the consoleService method to display a menu
            if (menuSelection == 1) { // list all hotels option
                // call the hotelService method to get a list of hotels from the API
                //      then give that list to the ConsoleService method to display it
                consoleService.printHotels(hotelService.listHotels());
            } else if (menuSelection == 2) { // list all reviews
                consoleService.printReviews(hotelService.listReviews());
            } else if (menuSelection == 3) { // list hotel id=1
                consoleService.printHotel(hotelService.getHotelById(1));
            } else if (menuSelection == 4) { // list reviews for a hotel
                consoleService.printReviews(hotelService.getReviewsByHotelId(1));
            } else if (menuSelection == 5) {
                System.out.println("Not implemented");
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                consoleService.exit();
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if(hotelId != 0) {
                consoleService.next(); // call a consoleService method to display a message and wait for user to press enter
            }
            // Ensure loop continues
            menuSelection = 999;
        }

        // if the loop exits, so does the program
        consoleService.exit(); // call a consoleService method to clean-up for the consoleService and terminate program
    }

}
