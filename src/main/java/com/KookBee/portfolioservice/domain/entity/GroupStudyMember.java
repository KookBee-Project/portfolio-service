package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.dto.GroupStudyMemberPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupStudyMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_stduy_member_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_study_id")
    private GroupStudy groupStudy;
    private Long userId;

    public GroupStudyMember(GroupStudyMemberPostDTO dto) {
        this.groupStudy = dto.getGroupStudy();
        this.userId = dto.getUserId();
    }
}
