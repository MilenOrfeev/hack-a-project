package com.example.travelly.controller;

import com.example.travelly.model.Listing;
import com.example.travelly.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

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

    @PostMapping(value = "someurl")
    public String getDestinationsFix(
            @RequestParam(value = "destination") String destination,
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            Model model) {
        Iterable<Listing> listings = listingService.findDestinationsBetween(destination, startDate, endDate);

        model.addAttribute("listings", listings);
        return "redirect:/search";
    }


    @GetMapping(value = "search")
    public String getDestinations(
            @RequestParam(value = "destination") String destination,
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            Model model) {
        Iterable<Listing> listings = listingService.findDestinationsBetween(destination, startDate, endDate);

        model.addAttribute("listings", listings);
        return "redirect:/";
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("listings", listingService.findAll());

        return "redirect:/homepage.html";
    }


}

