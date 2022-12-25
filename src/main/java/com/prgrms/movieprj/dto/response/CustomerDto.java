package com.prgrms.movieprj.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
public class CustomerDto {
    private int id;

    private String email;

    private String name;

    private String phoneNumber;

    private List<ReservationDto> reservationDtoList;
}
