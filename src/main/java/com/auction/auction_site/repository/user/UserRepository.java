package com.auction.auction_site.repository.user;

import com.auction.auction_site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
