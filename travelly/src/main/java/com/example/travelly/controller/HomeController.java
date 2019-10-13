package com.example.travelly.controller;

import com.example.travelly.model.Listing;
import com.example.travelly.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
//import org.springframework..ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

