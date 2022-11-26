package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.MovieDto;
import com.prgrms.movieprj.dto.ReviewDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAll();

    MovieDto findById(int id);

    default MovieDto entityToDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .timeTable(movie.getTimeTable())
                .running(movie.getRunning())
                .price(movie.getPrice())
                .build();
    }
}
