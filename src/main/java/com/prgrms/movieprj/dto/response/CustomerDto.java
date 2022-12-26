package com.prgrms.movieprj.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
public class CustomerDto {
    private Long id;

    private String email;

    private String name;

    private String phoneNumber;

}
