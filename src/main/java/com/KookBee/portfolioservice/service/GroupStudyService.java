package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.dto.GroupStudyLecturePostDTO;
import com.KookBee.portfolioservice.domain.dto.GroupStudyMemberPostDTO;
import com.KookBee.portfolioservice.domain.dto.GroupStudyPostDTO;
import com.KookBee.portfolioservice.domain.dto.UserDTO;
import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.entity.GroupStudyLecture;
import com.KookBee.portfolioservice.domain.entity.GroupStudyMember;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyLectureRegisterRequest;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyRegisterRequest;
import com.KookBee.portfolioservice.domain.response.PortfolioStudyResponse;
import com.KookBee.portfolioservice.repository.GroupStudyLectureRepository;
import com.KookBee.portfolioservice.repository.GroupStudyMemberRepository;
import com.KookBee.portfolioservice.repository.GroupStudyRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupStudyService {
    private final JwtService jwtService;
    private final GroupStudyRepository groupStudyRepository;
    private final GroupStudyMemberRepository groupStudyMemberRepository;
    private final UserServiceClient userServiceClient;
    private final GroupStudyLectureRepository groupStudyLectureRepository;

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
        Page<GroupStudy> studies = groupStudyRepository.findProceedingGroupStudies(status, pageable);
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
        Page<GroupStudy> studies = groupStudyRepository.findMyGroupStudies(status, userId, pageable);
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
}
