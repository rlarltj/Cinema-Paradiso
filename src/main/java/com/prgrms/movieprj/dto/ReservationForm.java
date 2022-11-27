package com.prgrms.movieprj.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReservationForm {
    private String email;
    private String name;
    private String phoneNumber;

    private int movieId;
    private int price;
    private int quantity;
}
