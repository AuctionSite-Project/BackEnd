package com.auction.auction_site.service;

import com.auction.auction_site.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("tests")
public class RegisterServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원을 등록한다")
    public void 회원_등록() throws Exception
    {
        //given
        //회원이 주어졌을 때

        //when
        //회원 등록 메소드가 실행되면

        //then
        //회원이 저장된다
    }

}
