package com.prgrms.movieprj.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewForm {
    @NotBlank
    private String reviewText;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private int score;

    private int movieId;
}
