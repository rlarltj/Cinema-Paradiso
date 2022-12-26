package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.ApiResponse;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/movie/{movieId}")
    public ApiResponse<List<ReviewDto>> showMovieReviews(@PathVariable int movieId) {
        List<ReviewDto> reviews = reviewService.findByMovie(movieId);

        return ApiResponse.ok(reviews);
    }

    @GetMapping("/customer/{customerId}")
    public ApiResponse<List<ReviewDto>> showCustomerReviews(@PathVariable int customerId) {
        List<ReviewDto> reviews = reviewService.findByCustomer(customerId);

        return ApiResponse.ok(reviews);
    }

    @PostMapping
    public ApiResponse<Long> register(@RequestBody ReviewForm reviewForm) {
        Long reviewId = reviewService.register(reviewForm);

        return ApiResponse.created(reviewId);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        reviewService.deleteReview(id);

        return ApiResponse.ok(id);
    }
}
