package com.example.travelly.repository;

import com.example.travelly.model.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Long> {
    public Listing findById(Long id);
}
