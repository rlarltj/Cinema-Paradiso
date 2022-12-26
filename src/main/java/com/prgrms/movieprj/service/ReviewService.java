package com.prgrms.movieprj.service;

import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.ReviewDto;

import java.util.List;

public interface ReviewService {
    Long register(ReviewForm reviewForm);

    void deleteReview(Long id);

    List<ReviewDto> findByMovie(int movieId);

    List<ReviewDto> findByCustomer(int customerId);
}
