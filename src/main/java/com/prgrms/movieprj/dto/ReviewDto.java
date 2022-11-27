package com.prgrms.movieprj.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private int id;
    private String reviewText;
    private CustomerDto customer;
    private MovieDto movie;
    private int score;
}
