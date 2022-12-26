package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.repository.ReservationRepository;
import com.prgrms.movieprj.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final EntityConverter converter;

    @Transactional
    @Override
    public Long reserve(ReservationForm reservationForm) {
        Customer customer = customerRepository.findByName(reservationForm.getCustomerName())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Reservation reservation = converter.dtoToReservation(reservationForm);
        reservationRepository.save(reservation);

        return reservation.getId();

    }

    @Override
    public List<ReservationDto> findByEmail(String email) {
        List<Reservation> reservations = reservationRepository.findByEmail(email);

        if (reservations.isEmpty()) {
            throw new RuntimeException("예매 내역이 없습니다.");
        }

        return reservations.stream()
                .map(reservation -> converter.reservationToDto(reservation))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void cancel(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public ReservationDto findById(Long reserveId) {
        Reservation reservation = reservationRepository.findById(reserveId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예약번호입니다."));

        return converter.reservationToDto(reservation);
    }
}
