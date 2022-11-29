package com.prgrms.movieprj.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationDto {
    private int id;
    private CustomerDto customer;
    private MovieDto movie;

    private int price;
    private int quantity;
}
