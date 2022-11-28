package com.prgrms.movieprj.dto;

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

    private int movieId;

    @NotBlank
    private int score;
}
