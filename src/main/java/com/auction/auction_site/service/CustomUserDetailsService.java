package com.auction.auction_site.service;

import com.auction.auction_site.dto.CustomUserDetails;
import com.auction.auction_site.entity.User;
import com.auction.auction_site.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private static final int LOGIN_USER = 0;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userRepository.findByUsername(username);

        if(user.get(LOGIN_USER) != null) {
            return new CustomUserDetails(user.get(LOGIN_USER));
        }

        return null;
    }
}
