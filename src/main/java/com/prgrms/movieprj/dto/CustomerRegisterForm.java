package com.prgrms.movieprj.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerRegisterForm {
    @NotNull(message = "이메일은 필수 입력사항입니다.")
    private String email;

    @NotNull(message = "이름은 필수 입력사항입니다.")
    private String name;

    @NotNull(message = "핸드폰 번호를 입력해주세요.")
    private String phoneNumber;
}
