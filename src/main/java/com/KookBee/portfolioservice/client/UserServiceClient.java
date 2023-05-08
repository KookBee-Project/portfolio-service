package com.KookBee.portfolioservice.client;

import com.KookBee.portfolioservice.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceClient {
    @GetMapping("/user/{userId}")
    UserDTO getUserById(@PathVariable("userId") Long userId);

    // id리스트로 name리스트 받아오기.. get매핑으로 어떻게 하지..
    @PostMapping("/user/namelist")
    List<UserDTO> getUserListById(List<Long> userIds);

}
