package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.repository.ReviewRepository;
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

    @Transactional
    @Override
    public ReviewDto register(ReviewForm reviewForm) {
        Customer customer = customerRepository.findByEmail(reviewForm.getEmail())
                .orElseThrow(() -> new RuntimeException("미가입 회원입니다."));

        Review review = getReview(reviewForm, customer);

        Review saveOne = reviewRepository.save(review);

        return entityToDto(saveOne);
    }

    @Transactional
    @Override
    public void deleteReview(int id) {
        Review review = Review.builder().id(id).build();
        reviewRepository.delete(review);
    }

    @Override
    public List<ReviewDto> findByMovie(int movieId) {
        List<Review> reviews = reviewRepository.findByMovie(movieId);

        return reviews.stream()
                .map(review -> entityToDto(review))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findByCustomer(int customerId) {
        List<Review> reviews = reviewRepository.findByCustomer(customerId);

        return reviews.stream()
                .map(review -> entityToDto(review))
                .collect(Collectors.toList());
    }


    private Review getReview(ReviewForm reviewForm, Customer customer) {
        return Review.builder()
                .reviewText(reviewForm.getReviewText())
                .customer(Customer.builder().id(customer.getId()).build())
                .movie(Movie.builder().id(reviewForm.getMovieId()).build())
                .score(reviewForm.getScore())
                .build();
    }
}
