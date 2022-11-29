package com.prgrms.movieprj.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@Builder
public class ReservationForm {
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;

    private int movieId;
    @NotBlank
    private int price;
    @NotBlank
    private int quantity;
}
