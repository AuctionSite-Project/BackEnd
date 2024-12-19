package com.auction.auction_site.entity;

import com.auction.auction_site.dto.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String phoneNumber;

    private String address;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
