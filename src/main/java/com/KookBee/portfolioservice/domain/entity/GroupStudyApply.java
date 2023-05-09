package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.dto.GroupStudyApplyPostDTO;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupStudyApply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_study_apply_id")
    private Long id;
    private Long groupStudyApplicantId;
    private String groupStudyApplicantName;
    private String groupStudyApplyContents;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_study_id")
    private GroupStudy groupStudy;
    @Enumerated(EnumType.STRING)
    private EStudyApplyStatus eStudyApplyStatus;

    public GroupStudyApply(GroupStudyApplyPostDTO dto) {
        this.groupStudyApplicantId = dto.getGroupStudyApplicantId();
        this.groupStudyApplicantName = dto.getGroupStudyApplicantName();
        this.groupStudyApplyContents = dto.getGroupStudyApplyContents();
        this.groupStudy = dto.getGroupStudy();
        this.eStudyApplyStatus = dto.getEStudyApplyStatus();
    }
}
