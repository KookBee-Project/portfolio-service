package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.dto.GroupStudyPostDTO;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupStudy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_study_id")
    private Long id;
    private String groupStudyName;
    private Long groupStudyLeader; // 스터디 리더의 userId
    private String groupStudyPurpose;
    @Enumerated(EnumType.STRING)
    private EStudyStatus groupStudyStatus;
    private LocalDate groupStudyOpenDate;

    @OneToMany(mappedBy = "groupStudy", fetch = FetchType.LAZY)
    private List<GroupStudyMember> groupStudyMembers;

    @OneToMany(mappedBy = "groupStudy", fetch = FetchType.LAZY)
    private List<GroupStudyLecture> groupStudyLectureList;

    @OneToMany(mappedBy = "groupStudy", fetch = FetchType.LAZY)
    private List<GroupStudyApply> groupStudyApplies;

    public GroupStudy(GroupStudyPostDTO dto) {
        this.groupStudyName = dto.getGroupStudyName();
        this.groupStudyLeader = dto.getGroupStudyLeader();
        this.groupStudyPurpose = dto.getGroupStudyPurpose();
        this.groupStudyStatus = dto.getGroupStudyStatus();
        this.groupStudyOpenDate = dto.getGroupStudyOpenDate();
    }
}
