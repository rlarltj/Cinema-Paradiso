package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDto> register(@RequestBody ReviewForm reviewForm) {
        ReviewDto review = reviewService.register(reviewForm);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
