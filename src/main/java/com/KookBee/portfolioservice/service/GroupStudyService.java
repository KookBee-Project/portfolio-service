package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.dto.*;
import com.KookBee.portfolioservice.domain.entity.*;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import com.KookBee.portfolioservice.domain.request.*;
import com.KookBee.portfolioservice.domain.response.*;
import com.KookBee.portfolioservice.repository.*;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupStudyService {
    private final JwtService jwtService;
    private final GroupStudyRepository groupStudyRepository;
    private final GroupStudyMemberRepository groupStudyMemberRepository;
    private final UserServiceClient userServiceClient;
    private final GroupStudyLectureRepository groupStudyLectureRepository;
    private final GroupStudyPostRepository groupStudyPostRepository;
    private final GroupStudyReviewRepository groupStudyReviewRepository;
    private final GroupStudyApplyRepository groupStudyApplyRepository;

    @Transactional
    public void registerGroupStudy(PortfolioStudyRegisterRequest request){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        GroupStudyPostDTO dto = new GroupStudyPostDTO(request, userId);
        GroupStudy saveStudy = groupStudyRepository.save(new GroupStudy(dto));

        for (Long el: request.getUserIdList()) {
            GroupStudyMemberPostDTO memberPostDTO = new GroupStudyMemberPostDTO(saveStudy, el);
            groupStudyMemberRepository.save(new GroupStudyMember(memberPostDTO));
        }

    }

    public Page<PortfolioStudyResponse> findStudyList(Pageable pageable){
        EStudyStatus status = EStudyStatus.PROCEEDING;
        Page<GroupStudy> studies;
        studies = groupStudyRepository.findProceedingGroupStudies(status, pageable);
        // 리더의 Id를 리스트로 생성
        List<Long> leaderIds = studies.stream().map(el->{
            return el.getGroupStudyLeader();
        }).toList();
        // 이름list 반환
        List<UserDTO> userListById = userServiceClient.getUserListById(leaderIds);

        final int[] cnt = {0};
        List<PortfolioStudyResponse> responsList = studies.stream().map((el)->{
            UserDTO userById = userListById.get(cnt[0]); // leaderName
            cnt[0]++;
            Integer memberCounts = el.getGroupStudyMembers().size();
            return new PortfolioStudyResponse(el, userById, memberCounts);// GroupStudy
        }).toList();
        Integer totalSize = groupStudyRepository.groupStudyCounts(status);
        return new PageImpl<>(responsList,pageable,totalSize);
    }

    public Page<PortfolioStudyResponse> findMyStudyList(Pageable pageable){
        EStudyStatus status = EStudyStatus.PROCEEDING;
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId(); // 나의 userId
        Page<GroupStudy> studies;
        studies = groupStudyRepository.findMyGroupStudies(status, userId, pageable);
        // 리더의 Id를 리스트로 생성
        List<Long> leaderIds = studies.stream().map(el->{
            return el.getGroupStudyLeader();
        }).toList();
        // 이름list 반환
        List<UserDTO> userListById = userServiceClient.getUserListById(leaderIds);
        final int[] cnt = {0};
        List<PortfolioStudyResponse> responsList = studies.stream().map((el)->{
            UserDTO userById = userListById.get(cnt[0]); // leaderName
            cnt[0]++;
            Integer memberCounts = el.getGroupStudyMembers().size();
            return new PortfolioStudyResponse(el, userById, memberCounts);// GroupStudy
        }).toList();
        Integer totalSize = groupStudyRepository.groupStudyCounts(status);
        return new PageImpl<>(responsList,pageable,totalSize);
    }

    public void registerGroupStudyLecture(PortfolioStudyLectureRegisterRequest request, Long groupStudyId){
        // 유저가 이 스터디의 리더인가
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        GroupStudy groupStudy = groupStudyRepository.findById(groupStudyId).get();
        if (groupStudy.getGroupStudyLeader() == userId){
            // 회차추가
            GroupStudyLecturePostDTO dto = new GroupStudyLecturePostDTO(request, groupStudy);
            groupStudyLectureRepository.save(new GroupStudyLecture(dto));
        }
    }

    public PortfolioStudyCheckResponse findLectureList(Long groupStudyId){
        // 스터디에 속해있는 지 확인
        List<Long> memberIdList = groupStudyMemberRepository.groupStudyMemberIdList(groupStudyId);
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        PortfolioStudyCheckResponse response = new PortfolioStudyCheckResponse();
        if (memberIdList.contains(userId)){
            List<GroupStudyLecture> byGroupStudyId = groupStudyLectureRepository.findByGroupStudyId(groupStudyId);
            List<PortfolioStudyLectureResponse> lectureResponseList = byGroupStudyId.stream().map(el->{
                Integer postCounts = groupStudyPostRepository.postCounts(el.getId());
                return new PortfolioStudyLectureResponse(el, postCounts);
            }).toList();
            response.setResponseList(lectureResponseList);
            response.setStudyJoin(true);
        } else {
            response.setResponseList(null);
            response.setStudyJoin(false);
        }
        // 스터디 회차 리스트 반환
        return response;
    }

    public void registerGroupStudyPost(PortfolioStudyPostRegisterRequest request, Long lectureId){
        GroupStudyLecture lecture = groupStudyLectureRepository.findById(lectureId).orElse(null);
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        GroupStudyPostPostDTO dto = new GroupStudyPostPostDTO(request, userId, lecture);
        groupStudyPostRepository.save(new GroupStudyPost(dto));
    }

    public List<PortfolioStudyPostResponse> findPostList(Long lectureId){
        List<GroupStudyPost> postList = groupStudyPostRepository.findAllByLectureId(lectureId);
        List<PortfolioStudyPostResponse> responses = postList.stream().map(el->{
            String userName = userServiceClient.getUserById(el.getGroupStudyPostWriter()).getUserName();
            List<PortfolioStudyReviewResponse> reviewList =
                    groupStudyReviewRepository.findAllByPostId(el.getId()).stream().map(el2->{
                return new PortfolioStudyReviewResponse(el2);
            }).toList();
            return new PortfolioStudyPostResponse(el, userName, reviewList);
        }).toList();
        return responses;
    }

    public void registerGroupStudyReview(PortfolioStudyReviewRegisterRequest request, Long postId){
        GroupStudyPost post = groupStudyPostRepository.findById(postId).orElse(null);
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        String userName = userServiceClient.getUserById(userId).getUserName();
        GroupStudyReviewPostDTO dto = new GroupStudyReviewPostDTO(request, post, userId, userName);
        groupStudyReviewRepository.save(new GroupStudyReview(dto));
    }

    public void applyGroupStudy(PortfolioStudyApplyRequest request, Long studyId){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        String userName = userServiceClient.getUserById(userId).getUserName();
        GroupStudy study = groupStudyRepository.findById(studyId).orElse(null);
        GroupStudyApplyPostDTO dto = new GroupStudyApplyPostDTO(request, study, userId, userName);
        groupStudyApplyRepository.save(new GroupStudyApply(dto));
    }

    public List<PortfolioStudyApplyResponse> findStudyApplyList(){
        try {
            EStudyStatus status = EStudyStatus.PROCEEDING;
            Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
            List<GroupStudyApply> applyList = groupStudyApplyRepository
                    .findAllByLeaderId(userId, status);
            // 리스폰스를 만들어준다.
            List<PortfolioStudyApplyResponse> responses = applyList.stream().map(el -> {
                return new PortfolioStudyApplyResponse(el);
            }).toList();
            return responses;
        }catch(Exception e){
            System.out.print("토큰이 만료되었습니다.");
            throw new RuntimeException();
        }
    }

    @Transactional
    public String putStudyApply(Long applyId, PortfolioStudyApplyPutRequest request){
        GroupStudyApplyPutDTO dto = new GroupStudyApplyPutDTO(request, applyId);
        GroupStudyApply apply = groupStudyApplyRepository.findById(applyId).orElse(null);
        apply.updateApplyStatus(dto);
        groupStudyApplyRepository.save(apply);
        if (apply.getEStudyApplyStatus() == EStudyApplyStatus.APPROVAL){
            GroupStudyMemberPostDTO memberPostDTO = new GroupStudyMemberPostDTO(apply);
            groupStudyMemberRepository.save(new GroupStudyMember(memberPostDTO));
        }
        return String.valueOf(dto.getEStudyApplyStatus());
    }

    public List<PortfolioStudyApplyRequestedResponse> findRequestedApplyList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // 나의 아이디를 가진 신청목록 조회
        List<GroupStudyApply> applyList = groupStudyApplyRepository.findByApplicantId(userId);
        List<PortfolioStudyApplyRequestedResponse> responses = applyList.stream().map(el->{
            return new PortfolioStudyApplyRequestedResponse(el);
        }).toList();
        return responses;
    }
}
