package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.CustomerDto;
import com.prgrms.movieprj.dto.MovieDto;
import com.prgrms.movieprj.dto.ReviewDto;
import com.prgrms.movieprj.dto.ReviewForm;

import java.util.List;

public interface ReviewService {
    ReviewDto register(ReviewForm reviewForm);

    void deleteReview(int id);

    List<ReviewDto> findByMovie(int movieId);

    List<ReviewDto> findByCustomer(int customerId);

    default ReviewDto entityToDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .reviewText(review.getReviewText())
                .customer(
                        CustomerDto.builder()
                                .id(review.getCustomer().getId())
                                .name(review.getCustomer().getName())
                                .email(review.getCustomer().getEmail())
                                .phoneNumber(review.getCustomer().getPhoneNumber())
                                .build())
                .movie(
                        MovieDto.builder()
                                .id(review.getMovie().getId())
                                .name(review.getMovie().getName())
                                .director(review.getMovie().getDirector())
                                .price(review.getMovie().getPrice())
                                .running(review.getMovie().getRunning())
                                .timeTable(review.getMovie().getTimeTable()).build())
                .score(review.getScore())
                .build();
    }
}
