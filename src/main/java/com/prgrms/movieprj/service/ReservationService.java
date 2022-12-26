package com.prgrms.movieprj.service;

import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ReservationDto;

import java.util.List;

public interface ReservationService {
    Long reserve(ReservationForm reservationForm);

    List<ReservationDto> findByEmail(String email);

    void cancel(Long reservationId);

    ReservationDto findById(Long reserveId);
}
