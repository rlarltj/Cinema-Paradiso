package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.response.MovieDto;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.service.MovieService;
import com.prgrms.movieprj.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/review/{movieId}")
    public ResponseEntity<List<ReviewDto>> showMovieReviews(@PathVariable int movieId) {
        List<ReviewDto> reviews = reviewService.findByMovie(movieId);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        List<MovieDto> movieDtoList = movieService.findAll();

        return new ResponseEntity<>(movieDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findOne(@PathVariable int id) {
        MovieDto movieDto = movieService.findById(id);

        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }
}
