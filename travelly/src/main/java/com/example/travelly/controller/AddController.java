package com.example.travelly.controller;

import com.example.travelly.model.Listing;
import com.example.travelly.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(value = "/create")
public class AddController {
    @Autowired
    private ListingRepository listingRepository;

    @GetMapping(value = "/new")
    public String addEvent(
            @RequestParam(value = "location") String location,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "depart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departDate,
            @RequestParam(value = "return") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate
            ) {
        Listing listing = new Listing();
        listing.setDestination(location);
        listing.setDescription(description);
        listing.setStartDate(departDate);
        listing.setEndDate(returnDate);
        listingRepository.save(listing);

        return "redirect:/trip.html";
    }
}
