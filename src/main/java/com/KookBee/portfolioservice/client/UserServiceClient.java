package com.KookBee.portfolioservice.client;

import com.KookBee.portfolioservice.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceClient {
    @GetMapping("/user/{userId}")
    UserDTO getUserById(@PathVariable("userId") Long userId);

}
