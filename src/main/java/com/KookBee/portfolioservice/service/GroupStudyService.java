package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.dto.GroupStudyMemberPostDTO;
import com.KookBee.portfolioservice.domain.dto.GroupStudyPostDTO;
import com.KookBee.portfolioservice.domain.dto.UserDTO;
import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.entity.GroupStudyMember;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyRegistRequest;
import com.KookBee.portfolioservice.domain.response.PortfolioStudyResponse;
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

    @Transactional
    public void registGroupStudy(PortfolioStudyRegistRequest request){
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
        List<GroupStudy> studies = groupStudyRepository.findProceedingGroupStudies(status);
        List<PortfolioStudyResponse> responsList = studies.stream().map(el->{
            UserDTO userById = userServiceClient.getUserById(el.getGroupStudyLeader());// leaderName
            Integer memberCounts = groupStudyMemberRepository.memberCounts(el.getId());// memberCounts
            return new PortfolioStudyResponse(el, userById, memberCounts);// GroupStudy
        }).toList();
        int totalSize = responsList.size();
        return new PageImpl<>(responsList,pageable,totalSize);
    }
}
