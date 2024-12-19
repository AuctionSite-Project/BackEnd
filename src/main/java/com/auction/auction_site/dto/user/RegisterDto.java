package com.auction.auction_site.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotBlank(message = "회원 이름은 필수 항목입니다.")
    private String username;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인 입력은 필수입니다.")
    private String password_chk;

    @NotBlank(message = "닉네임 입력은 필수입니다.")
    private String nickname;

    private String phoneNumber;

    private String address;

    private String accountNumber;
}
