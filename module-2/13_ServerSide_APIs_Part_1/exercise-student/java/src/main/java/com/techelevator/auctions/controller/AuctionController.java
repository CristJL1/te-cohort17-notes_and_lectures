package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

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
    public List<Auction> list(@RequestParam(required = false) String title_like, @RequestParam(required = false) Double currentBid_lte) {
        try {
            if (currentBid_lte > 0 && title_like != null) {
                return dao.searchByTitleAndPrice(title_like, currentBid_lte);
            }
            else if (title_like != null && currentBid_lte == 0) {
                return dao.searchByTitle(title_like);
            }
            else if (currentBid_lte > 0 && title_like == null) {
                return dao.searchByPrice(currentBid_lte);
            }
            else return dao.list();
        } catch (NullPointerException ex) {
            if (title_like == null) {
                return dao.list();
            }
            else {
                return dao.searchByTitle(title_like);
            }
        }
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        System.out.println("Auction Search by ID Returned");
        return dao.get(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction) {
        System.out.println("Created new Auction called " + newAuction.getTitle());
        try {
            dao.create(newAuction);
        } catch (RestClientResponseException ex) {
            ex.getStatusText();
        } catch (ResourceAccessException ex) {
            ex.getMessage();
        }
        return newAuction;
    }



} // end of controller class
