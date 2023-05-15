package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.response.MyPageStudyListResponse;
import com.KookBee.portfolioservice.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/portfolio/my")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/study")
    public List<MyPageStudyListResponse> getStudyList(){
        return myPageService.getStudyPostList();
    }
}
