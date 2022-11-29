package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.CustomerDto;
import com.prgrms.movieprj.dto.response.MovieDto;
import com.prgrms.movieprj.dto.response.ReviewDto;

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
                                .build())
                .score(review.getScore())
                .build();
    }
}
