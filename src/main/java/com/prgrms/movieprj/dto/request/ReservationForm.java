package com.prgrms.movieprj.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
public class ReservationForm {
    @NotNull(message = "{exception.customer.id.null}")
    private Long customerId;

    @NotBlank(message = "{exception.customer.email.null}")
    private String customerEmail;

    @NotBlank(message = "{exception.customer.name.null}")
    private String customerName;

    @NotBlank(message = "{exception.customer.phoneNumber.null}")
    @Length(min = 11, max = 15, message = "{exception.customer.phoneNumber.length}")
    private String phoneNumber;

    @NotNull
    private Long movieId;

    @NotNull(message = "{exception.reservation.quantity.null}")
    @Positive(message = "{exception.reservation.quantity.positive}")
    private int quantity;

    @NotNull(message = "{exception.reservation.price.null}")
    @Positive(message = "{exception.reservation.price.positive}")
    private int price;
}
