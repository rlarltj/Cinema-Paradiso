package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.ReservationDto;
import com.prgrms.movieprj.dto.ReservationForm;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.repository.MovieRepository;
import com.prgrms.movieprj.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;

    @Override
    public ReservationDto reserve(ReservationForm reservationForm) {

        Optional<Customer> findCustomer = customerRepository.findByEmail(reservationForm.getEmail());
        Optional<Movie> findMovie = movieRepository.findById(reservationForm.getMovieId());

        if (findCustomer.isPresent()) {
            Customer customer = findCustomer.get();
            Reservation reservation = new Reservation(customer, findMovie.get(), reservationForm.getQuantity(), reservationForm.getPrice());
            Reservation save = reservationRepository.save(reservation);

            return entityToDto(save);
        }

        Customer newCustomer = Customer.builder()
                .name(reservationForm.getName())
                .email(reservationForm.getEmail())
                .phoneNumber(reservationForm.getPhoneNumber())
                .build();

        Customer savedOne = customerRepository.save(newCustomer);

        Reservation reservation = Reservation.builder()
                .movie(Movie.builder()
                        .id(reservationForm.getMovieId())
                        .build())
                .customer(Customer.builder()
                        .id(savedOne.getId())
                        .email(reservationForm.getEmail())
                        .name(reservationForm.getName())
                        .phoneNumber(reservationForm.getPhoneNumber())
                        .build())
                .price(reservationForm.getPrice() * reservationForm.getQuantity())
                .quantity(reservationForm.getQuantity())
                .build();

        Reservation save = reservationRepository.save(reservation);

        return entityToDto(save);
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
