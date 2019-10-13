package com.example.travelly.repository;

import com.example.travelly.model.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface ListingRepository extends CrudRepository<Listing, Long> {
    Optional<Listing> findById(Long id);
    Iterable<Listing> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndDestination(Date startDate, Date endDate, String destination);
}
