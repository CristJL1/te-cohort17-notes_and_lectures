package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping BEFORE the Controller class
// sets the default base path for all paths specified in other @RequestMapping
//
// for example: if you want controller for path "/auctions" - @RequestMapping("", method = ......)
// for example: if you want controller for path "/auctions/{id}" - @RequestMapping("/{id}", method = ......)

@RequestMapping("/auctions") // this controller will handle all/auctions paths
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {

        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list() {
        System.out.println("List of Auctions Returned");
        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        System.out.println("Auction Search by ID Returned");
        return dao.get(id);
    }

} // end of controller class
