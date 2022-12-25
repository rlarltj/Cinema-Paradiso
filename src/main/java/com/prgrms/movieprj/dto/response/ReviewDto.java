package com.prgrms.movieprj.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class ReviewDto {
    private int id;
    private String reviewText;
    private CustomerDto customer;
    private MovieDto movie;
    private int score;
}
