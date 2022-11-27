package com.prgrms.movieprj.dto;

import com.prgrms.movieprj.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;

    private String email;

    private String name;

    private String phoneNumber;

    private List<ReservationDto> reservationDtoList;
}
