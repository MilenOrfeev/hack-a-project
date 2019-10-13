package com.example.travelly.service;

import com.example.travelly.model.Listing;
import org.springframework.stereotype.Service;

@Service
public class ListingService {
    public Iterable<Listing> findAllUpcoming() {
        return null;
    }

    public Listing findByID(long id) {return null;} //To be used when displaying page for specific travel listing

}
