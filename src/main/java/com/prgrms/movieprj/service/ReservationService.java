package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.CustomerDto;
import com.prgrms.movieprj.dto.MovieDto;
import com.prgrms.movieprj.dto.ReservationDto;
import com.prgrms.movieprj.dto.ReservationForm;

import java.util.List;

public interface ReservationService {
    ReservationDto reserve(ReservationForm reservationForm);

    List<ReservationDto> findByEmail(String email);

    void cancel(int reservationId);

    default ReservationDto entityToDto(Reservation reservation) {
        Customer customer = reservation.getCustomer();
        Movie movie = reservation.getMovie();

        return ReservationDto.builder()
                .id(reservation.getId())
                .customer(
                        CustomerDto.builder().id(customer.getId())
                                .name(customer.getName())
                                .email(customer.getEmail())
                                .phoneNumber(customer.getPhoneNumber())
                                .build())
                .movie(
                        MovieDto.builder()
                                .id(movie.getId())
                                .name(movie.getName())
                                .director(movie.getDirector())
                                .price(movie.getPrice())
                                .running(movie.getRunning())
                                .timeTable(movie.getTimeTable())
                                .build()
                )
                .price(reservation.getPrice())
                .quantity(reservation.getQuantity())
                .build();
    }
}
