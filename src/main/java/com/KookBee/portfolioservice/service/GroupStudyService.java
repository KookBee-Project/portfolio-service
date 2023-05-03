package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.domain.dto.GroupStudyPostDTO;
import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.request.PortFolioStudyRegistRequest;
import com.KookBee.portfolioservice.repository.GroupStudyRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupStudyService {
    private final JwtService jwtService;
    private final GroupStudyRepository groupStudyRepository;


    public void registGroupStudy(PortFolioStudyRegistRequest request){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        GroupStudyPostDTO dto = new GroupStudyPostDTO(request, userId);
        groupStudyRepository.save(new GroupStudy(dto));
    }
}
