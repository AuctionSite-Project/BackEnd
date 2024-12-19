package com.auction.auction_site.service.user;

import com.auction.auction_site.dto.user.RegisterDto;

public interface UserService {

    Long register(RegisterDto userDto);
}
