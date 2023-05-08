package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.PortfolioStudyLectureRegisterRequest;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyRegisterRequest;
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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerGroupStudy(@RequestBody PortfolioStudyRegisterRequest request){
        groupStudyService.registerGroupStudy(request);
    }

    @GetMapping("/findstudy")
    public Page<PortfolioStudyResponse> getStudyList(@RequestParam("page") Integer page){
        final int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return groupStudyService.findStudyList(pageable);
    }

    @GetMapping
    public Page<PortfolioStudyResponse> getMyStudyList(@RequestParam("page") Integer page){
        final int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return groupStudyService.findMyStudyList(pageable);
    }

    @PostMapping("/{studyId}/lecture/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerGroupStudyLecture(@PathVariable("studyId") Long groupStudyId,
                                          @RequestBody PortfolioStudyLectureRegisterRequest request){
        groupStudyService.registerGroupStudyLecture(request, groupStudyId);
    }

}
