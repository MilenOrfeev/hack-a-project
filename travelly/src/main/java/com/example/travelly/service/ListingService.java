package com.example.travelly.service;

import com.example.travelly.model.Listing;
import com.example.travelly.model.User;
import com.example.travelly.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public Iterable<Listing> findAllUpcoming() {
        return listingRepository.findAll();
    }

    public Listing findByID(long id) {return null;} //To be used when displaying page for specific travel listing
    public Iterable<Listing> findAll(){return listingRepository.findAll();}

    public void addUserToListing(Long id){
        Listing listing = listingRepository.findById(id).orElse(new Listing());

        List<User> currentList = listing.getParticipants();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof User) {
            currentList.add((User)principal);
        } else {
            //return error saying that user must be logged in to join
        }


        listing.setParticipants(currentList);

        listingRepository.save(listing);
    }

    public Iterable<Listing> findDestinationsBetween(String destination, Date startDate, Date endDate) {
        return listingRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndDestination(startDate, endDate, destination);
    }

}
