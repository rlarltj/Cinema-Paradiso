package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "select m, count(r) as reviewNum from Movie m" +
            " left join Review r on r.movie = m group by m.id")
    List<Object[]> findMovieWithReviewCnt();
}
