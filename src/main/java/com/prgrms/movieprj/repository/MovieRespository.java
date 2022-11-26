package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRespository extends JpaRepository<Movie, Integer> {
}
