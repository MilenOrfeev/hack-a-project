package com.example.travelly.dao;

public interface ListingService {
    public Iterable<Listing> findAll();
    public Iterable<Listing> findAllUpcoming();
    public Iterable<Listing> findAllPrevious();


}
