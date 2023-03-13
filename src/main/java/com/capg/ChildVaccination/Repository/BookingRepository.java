package com.capg.ChildVaccination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capg.ChildVaccination.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>, PagingAndSortingRepository<Booking, Integer> {

}
