package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r " +
            "join fetch r.movie m " +
            "join fetch r.customer c " +
            "where m.id = :movieId")
    List<Review> findByMovie(int movieId);


    @Query("select r from Review r " +
            "join r.customer c " +
            "where c.id = :customerId")
    List<Review> findByCustomer(int customerId);
}
