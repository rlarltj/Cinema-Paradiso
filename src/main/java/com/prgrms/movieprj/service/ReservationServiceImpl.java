package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ReservationDto reserve(ReservationForm reservationForm) {

        Customer customer = customerRepository.findByEmail(reservationForm.getEmail())
                .orElseGet(() -> getCustomer(reservationForm));

        Customer savedOne = customerRepository.save(customer);

        Reservation reservation = getReservation(reservationForm, savedOne);

        Reservation save = reservationRepository.save(reservation);
        return entityToDto(save);

    }

    private Reservation getReservation(ReservationForm reservationForm, Customer savedOne) {
        return Reservation.builder()
                .movie(Movie.builder()
                        .id(reservationForm.getMovieId())
                        .build())
                .customer(Customer.builder()
                        .id(savedOne.getId())
                        .email(reservationForm.getEmail())
                        .name(reservationForm.getName())
                        .phoneNumber(reservationForm.getPhoneNumber())
                        .build())
                .price(reservationForm.getPrice())
                .quantity(reservationForm.getQuantity())
                .build();
    }

    private Customer getCustomer(ReservationForm reservationForm) {
        return Customer.builder()
                .name(reservationForm.getName())
                .email(reservationForm.getEmail())
                .phoneNumber(reservationForm.getPhoneNumber())
                .build();
    }

    @Override
    public List<ReservationDto> findByEmail(String email) {
        List<Reservation> reservations = reservationRepository.findByEmail(email);

        if (reservations.isEmpty()) {
            throw new RuntimeException("예매 내역이 없습니다.");
        }

        return reservations.stream()
                .map(reservation -> entityToDto(reservation))
                .collect(Collectors.toList());
    }


    @Override
    public void cancel(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
