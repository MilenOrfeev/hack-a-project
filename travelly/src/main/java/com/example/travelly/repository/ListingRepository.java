package com.example.travelly.repository;

import com.example.travelly.model.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ListingRepository extends CrudRepository<Listing, Long> {
    public Optional<Listing> findById(Long id);
}
