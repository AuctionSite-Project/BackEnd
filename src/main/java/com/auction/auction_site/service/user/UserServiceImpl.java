package com.auction.auction_site.service.user;

import com.auction.auction_site.dto.Role;
import com.auction.auction_site.dto.user.RegisterDto;
import com.auction.auction_site.entity.User;
import com.auction.auction_site.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final String EXIST_USER_MESSAGE = "이미 존재하는 회원입니다.";

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Long register(RegisterDto registerDto) {
        validateDuplicateAccount(registerDto.getUsername());

        User user = User.builder()
                .username(registerDto.getUsername())
                .password(bCryptPasswordEncoder.encode(registerDto.getPassword()))
                .nickname(registerDto.getNickname())
                .address(registerDto.getAddress())
                .accountNumber(registerDto.getAccountNumber())
                .phoneNumber(registerDto.getPhoneNumber())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateAccount(String username) {
        List<User> findMembers = userRepository.findByUsername(username);
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException(EXIST_USER_MESSAGE);
        }
    }
}
