package com.example.travelly.service;

import com.example.travelly.model.Listing;
import com.example.travelly.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public Iterable<Listing> findAllUpcoming() {
        return listingRepository.findAll();
    }

    public Listing findByID(long id) {return null;} //To be used when displaying page for specific travel listing

}
