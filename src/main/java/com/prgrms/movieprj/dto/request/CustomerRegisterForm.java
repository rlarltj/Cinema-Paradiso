package com.prgrms.movieprj.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRegisterForm {
    @NotBlank(message = "이메일은 필수 입력사항입니다.")
    private String email;

    @NotBlank(message = "이름은 필수 입력사항입니다.")
    private String name;

    @NotBlank(message = "핸드폰 번호를 입력해주세요.")
    private String phoneNumber;
}
