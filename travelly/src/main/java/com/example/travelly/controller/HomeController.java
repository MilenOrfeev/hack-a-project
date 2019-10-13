package com.example.travelly.controller;

import com.example.travelly.model.Listing;
import com.example.travelly.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(value = "/", produces = { MediaType.TEXT_HTML_VALUE })
public class HomeController {
    @Autowired
    private ListingService listingService;

    //@RequestMapping(method = RequestMethod.GET)
    //public String getListings(Model model) {
    //    Iterable<Listing> listings = listingService.findAllUpcoming();

    //    model.addAttribute("recentListings", listings);
    //    return "homepage/index";
    //}

    @GetMapping(value = "search")
    public String getDestinations(
            @RequestParam(value = "destination") String destination,
            @RequestParam(value = "startDate") Date startDate,
            @RequestParam(value = "endDate") Date endDate,
            Model model) {
        Iterable<Listing> listings = listingService.findDestinationsBetween(destination, startDate, endDate);

        model.addAttribute("listings", listings);
        return "homepage/index";
    }

}

