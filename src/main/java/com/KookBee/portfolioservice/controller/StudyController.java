package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.PortFolioStudyRegistRequest;
import com.KookBee.portfolioservice.service.GroupStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("portfolio/study")
@RequiredArgsConstructor
public class StudyController {
    private final GroupStudyService groupStudyService;

    @PostMapping("/regist")
    @ResponseStatus(HttpStatus.CREATED)
    public void registGroupStudy(@RequestBody PortFolioStudyRegistRequest request){
        groupStudyService.registGroupStudy(request);
    }

}
