package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.PortfolioStudyRegistRequest;
import com.KookBee.portfolioservice.domain.response.PortfolioStudyResponse;
import com.KookBee.portfolioservice.service.GroupStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portfolio/study")
@RequiredArgsConstructor
public class StudyController {
    private final GroupStudyService groupStudyService;

    @PostMapping("/regist")
    @ResponseStatus(HttpStatus.CREATED)
    public void registGroupStudy(@RequestBody PortfolioStudyRegistRequest request){
        groupStudyService.registGroupStudy(request);
    }

    @GetMapping("/findstudy")
    public Page<PortfolioStudyResponse> getStudyList(@RequestParam("page") Integer page){
        final int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return groupStudyService.findStudyList(pageable);
    }

}
