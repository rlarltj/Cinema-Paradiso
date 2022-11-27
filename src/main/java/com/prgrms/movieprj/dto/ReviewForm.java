package com.prgrms.movieprj.dto;

import lombok.Data;

@Data
public class ReviewForm {
    private String reviewText;

    private int customerId;
    private int movieId;
    private int score;
}
