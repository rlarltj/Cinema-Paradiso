package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.repository.ReviewRepository;
import com.prgrms.movieprj.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final EntityConverter converter;

    @Transactional
    @Override
    public Long register(ReviewForm reviewForm) {
        Customer customer = customerRepository.findByEmail(reviewForm.getEmail())
                .orElseThrow(() -> new RuntimeException("미가입 회원입니다."));

        Review review = converter.dtoToReview(reviewForm);
        reviewRepository.save(review);

        return review.getId();
    }

    @Transactional
    @Override
    public void deleteReview(Long id) {
        Review review = Review.builder()
                .id(id)
                .build();
        reviewRepository.delete(review);
    }

    @Override
    public List<ReviewDto> findByMovie(int movieId) {
        List<Review> reviews = reviewRepository.findByMovie(movieId);

        return reviews.stream()
                .map(review -> converter.reviewToDto(review))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findByCustomer(int customerId) {
        List<Review> reviews = reviewRepository.findByCustomer(customerId);

        return reviews.stream()
                .map(review -> converter.reviewToDto(review))
                .collect(Collectors.toList());
    }
}
