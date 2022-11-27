package com.prgrms.movieprj.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MovieRequestDto {
    private int movieId;
    private int price;
    private int quantity;
}
