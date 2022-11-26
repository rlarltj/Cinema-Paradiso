package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("select r from Reservation r join Customer c on r.customer = c where c.email = :email")
    List<Reservation> findByEmail(String email);
}
