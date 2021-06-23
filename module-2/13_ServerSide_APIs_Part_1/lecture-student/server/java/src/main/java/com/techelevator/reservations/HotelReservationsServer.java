package com.techelevator.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this is a Spring Boot Framework server
// Spring Boot is a set of classes to make server programming easier
//      (like Spring DAO Framework made database access easier)
// this gets generated for you when you use the Spring Initializer

@SpringBootApplication
public class HotelReservationsServer {

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationsServer.class, args);
    }

}
