package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.domain.response.MyPageStudyListResponse;
import com.KookBee.portfolioservice.repository.GroupStudyPostRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final JwtService jwtService;
    private final GroupStudyPostRepository groupStudyPostRepository;
    public List<MyPageStudyListResponse> getStudyPostList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<MyPageStudyListResponse> responses =
                groupStudyPostRepository.findAllByWriterId(userId).stream().map(el -> {
            return new MyPageStudyListResponse(el);
        }).toList();

        // 5개까지만 반환
        if (responses.size()>5){
            return responses.subList(0,5);
        } else {
            return responses;
        }
    }
}
