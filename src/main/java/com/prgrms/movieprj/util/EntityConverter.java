package com.prgrms.movieprj.util;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.domain.Review;
import com.prgrms.movieprj.dto.request.CustomerRegisterForm;
import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.request.ReviewForm;
import com.prgrms.movieprj.dto.response.CustomerDto;
import com.prgrms.movieprj.dto.response.MovieDto;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.dto.response.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {
    public Customer dtoToCustomer(CustomerRegisterForm registerForm) {
        return Customer.builder()
                .name(registerForm.getName())
                .email(registerForm.getEmail())
                .phoneNumber(registerForm.getPhoneNumber())
                .build();
    }

    public CustomerDto customerToDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }


    public MovieDto movieToDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .price(movie.getPrice())
                .running(movie.getRunning())
                .timeTable(movie.getTimeTable())
                .reviewNum(movie.getReviews().size())
                .build();
    }


    public Reservation dtoToReservation(ReservationForm reservationForm) {
        Customer customer = Customer.builder()
                .id(reservationForm.getCustomerId())
                .build();

        Movie movie = Movie.builder()
                .id(reservationForm.getMovieId())
                .build();

        return Reservation.builder()
                .customer(customer)
                .movie(movie)
                .price(reservationForm.getPrice())
                .quantity(reservationForm.getQuantity())
                .build();
    }

    public ReservationDto reservationToDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .customer(customerToDto(reservation.getCustomer()))
                .movie(movieToDto(reservation.getMovie()))
                .price(reservation.getPrice())
                .quantity(reservation.getQuantity())
                .build();
    }

    public Review dtoToReview(ReviewForm reviewForm) {
        Customer customer = Customer.builder()
                .id(reviewForm.getCustomerId())
                .build();

        Movie movie = Movie.builder()
                .id(reviewForm.getMovieId())
                .build();

        return Review.builder()
                .customer(customer)
                .movie(movie)
                .score(reviewForm.getScore())
                .reviewText(reviewForm.getReviewText())
                .build();
    }

    public ReviewDto reviewToDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .customer(customerToDto(review.getCustomer()))
                .movie(movieToDto(review.getMovie()))
                .score(review.getScore())
                .reviewText(review.getReviewText())
                .build();
    }
}
