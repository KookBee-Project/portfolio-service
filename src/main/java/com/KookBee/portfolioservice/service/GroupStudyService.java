package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.domain.dto.GroupStudyMemberPostDTO;
import com.KookBee.portfolioservice.domain.dto.GroupStudyPostDTO;
import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.entity.GroupStudyMember;
import com.KookBee.portfolioservice.domain.request.PortFolioStudyRegistRequest;
import com.KookBee.portfolioservice.repository.GroupStudyMemberRepository;
import com.KookBee.portfolioservice.repository.GroupStudyRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GroupStudyService {
    private final JwtService jwtService;
    private final GroupStudyRepository groupStudyRepository;
    private final GroupStudyMemberRepository groupStudyMemberRepository;

    @Transactional
    public void registGroupStudy(PortFolioStudyRegistRequest request){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        GroupStudyPostDTO dto = new GroupStudyPostDTO(request, userId);
        GroupStudy saveStudy = groupStudyRepository.save(new GroupStudy(dto));

        for (Long el: request.getUserIdList()) {
            GroupStudyMemberPostDTO memberPostDTO = new GroupStudyMemberPostDTO(saveStudy, el);
            groupStudyMemberRepository.save(new GroupStudyMember(memberPostDTO));
        }

    }
}
