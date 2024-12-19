package com.auction.auction_site.controller.user;

import com.auction.auction_site.dto.user.RegisterDto;
import com.auction.auction_site.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class UserApiController {
    private static final String NOT_SAME_PASSWORD_MESSAGE = "패스워드가 일치하지 않습니다.";
    private static final String SUCCESS_CREATE_USER_MESSAGE = "회원 가입에 성공하였습니다.";

    private static final Logger logger = LoggerFactory.getLogger(UserApiController.class);

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> join(@Valid @RequestBody RegisterDto registerDto) {
        logger.info("Controller - 회원가입 요청");
        if (!registerDto.getPassword().equals(registerDto.getPassword_chk())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(NOT_SAME_PASSWORD_MESSAGE);
        }
        try {
            Long userId = userService.register(registerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(SUCCESS_CREATE_USER_MESSAGE);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
