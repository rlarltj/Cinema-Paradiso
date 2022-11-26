package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

//    @EntityGraph(attributePaths = "movie", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select r, m from Review r join Movie m on r.movie = m where m.id = :movieId")
    List<Review> findByMovie(int movieId);

//    @EntityGraph(attributePaths = "customer", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select r from Review r join Customer c on r.customer = c where c.id = :customerId")
    List<Review> findByCustomer(int customerId);
}
