package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.ReservationDto;
import com.prgrms.movieprj.dto.ReservationForm;
import com.prgrms.movieprj.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public ReservationDto reserve(ReservationForm reservationForm) {
        Reservation reservation = Reservation.builder()
                .movie(Movie.builder()
                        .id(reservationForm.getMovieId())
                        .build())
                .customer(Customer.builder()
                        .id(reservationForm.getCustomerId())
                        .build())
                .build();

        Reservation save = reservationRepository.save(reservation);

        return entityToDto(save);
    }

    @Override
    public List<ReservationDto> findByEmail(String email) {
        List<Reservation> reservations = reservationRepository.findByEmail(email);

        return reservations.stream()
                .map(reservation -> entityToDto(reservation))
                .collect(Collectors.toList());
    }

    @Override
    public void cancel(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
