package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select r from Reservation r " +
            "join fetch r.customer c " +
            "join fetch r.movie m " +
            "where c.email = :email")
    List<Reservation> findByEmail(String email);
}
