package com.example.travelly.controller;

import com.example.travelly.model.Listing;
import com.example.travelly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.travelly.service.ListingService;

import java.util.List;

@Controller
@RequestMapping(value = "/show")
public class ListingController {

    @Autowired
    private ListingService listingService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String listing(@PathVariable("id") long id, Model model, @RequestParam(value = "message", required = false, defaultValue = "") String message) {
        Listing listing = listingService.findByID(id);
        if (listing == null)
            return "redirect:/listings";

        model.addAttribute("listing", listing);

        return "listings/show";

    }

    @RequestMapping(method = RequestMethod.POST)
    public List joinListing(@PathVariable("id") long id, Model model){
        //listingService.addUserToListing(id);
        return null;

    }
}
