package com.prgrms.movieprj.dto.request;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class ReviewForm {

    @NotBlank(message = "{exception.review.reviewText.null}")
    private String reviewText;

    @NotBlank(message = "{exception.customer.email.null}")
    private String email;

    @NotBlank(message = "{exception.customer.name.null}")
    private String name;

    @NotNull(message = "{exception.review.score.null}")
    @PositiveOrZero(message = "{exception.review.score.positiveOrZero}")
    private int score;

    private int movieId;
}
