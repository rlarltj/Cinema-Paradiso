package com.prgrms.movieprj.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class CustomerRegisterForm {
    @NotBlank(message = "{exception.customer.email.null}")
    private String email;

    @NotBlank(message = "{exception.customer.name.null}")
    private String name;

    @NotBlank(message = "{exception.customer.phoneNumber.null}")
    @Length(min = 11, max = 15, message = "{exception.customer.phoneNumber.length}")
    private String phoneNumber;
}
