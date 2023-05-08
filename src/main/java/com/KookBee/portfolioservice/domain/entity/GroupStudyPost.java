package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.dto.GroupStudyLecturePostDTO;
import com.KookBee.portfolioservice.domain.dto.GroupStudyPostPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupStudyPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_study_post_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_study_lecture_id")
    private GroupStudyLecture groupStudyLecture;
    private Long groupStudyPostWriter;
    private String groupStudyPostTitle;
    private String groupStudyPostContents;
    private LocalDate groupStudyPostCreateAt;

    public GroupStudyPost(GroupStudyPostPostDTO dto) {
        this.groupStudyLecture = dto.getGroupStudyLecture();
        this.groupStudyPostWriter = dto.getGroupStudyPostWriter();
        this.groupStudyPostTitle = dto.getGroupStudyPostTitle();
        this.groupStudyPostContents = dto.getGroupStudyPostContents();
        this.groupStudyPostCreateAt = dto.getGroupStudyPostCreateAt();
    }
}
