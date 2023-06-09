package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.*;
import com.KookBee.portfolioservice.domain.response.studyResponse.*;
import com.KookBee.portfolioservice.exception.AlreadyRegisteredMemberException;
import com.KookBee.portfolioservice.service.GroupStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{studyId}")
    public PortfolioStudyCheckResponse getStudyAndLectureList(
            @PathVariable("studyId") Long groupStudyId){
        return groupStudyService.findLectureList(groupStudyId);
    }

    @PostMapping("/{studyId}/lecture/{lectureId}/post/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerGroupStudyPost(@PathVariable("lectureId") Long lectureId,
                                       @RequestBody PortfolioStudyPostRegisterRequest request){
        groupStudyService.registerGroupStudyPost(request, lectureId);
    }

    @GetMapping("/{studyId}/lecture/{lectureId}")
    public List<PortfolioStudyPostResponse> getPostList(@PathVariable("lectureId") Long lectureId){
        return groupStudyService.findPostList(lectureId);
    }

    @PostMapping("/{studyId}/lecture/{lectureId}/post/{postId}/review/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerGroupStudyReview(@PathVariable("postId") Long postId,
                                         @RequestBody PortfolioStudyReviewRegisterRequest request){
        groupStudyService.registerGroupStudyReview(request, postId);
    }

    @PostMapping("/{studyId}/apply")
    @ResponseStatus(HttpStatus.CREATED)
    public void applyGroupStudy(@PathVariable("studyId") Long studyId,
                                @RequestBody PortfolioStudyApplyRequest request){
        groupStudyService.applyGroupStudy(request, studyId);
    }

    @GetMapping("/apply")
    public List<PortfolioStudyApplyResponse> getStudyApplyList(){
        return groupStudyService.findStudyApplyList();
    }

    @PutMapping("/apply/{applyId}")
    public String putStudyApply(@PathVariable("applyId") Long applyId,
                                @RequestBody PortfolioStudyApplyPutRequest request) throws AlreadyRegisteredMemberException {
        System.out.println(request.getStudyApplyStatus());
        return groupStudyService.putStudyApply(applyId,request);
    }

    @GetMapping("/apply/requested")
    public List<PortfolioStudyApplyRequestedResponse> getRequestedApplyList(){
        return groupStudyService.findRequestedApplyList();
    }

    @GetMapping("/home/list")
    public List<HomeStudyResponse> getMainStudyList() {
        return groupStudyService.getMainStudyList();
    }
}
