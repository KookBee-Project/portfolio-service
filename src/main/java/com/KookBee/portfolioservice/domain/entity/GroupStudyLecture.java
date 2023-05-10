package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.dto.GroupStudyLecturePostDTO;
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
public class GroupStudyLecture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_study_lecture_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_study_id")
    private GroupStudy groupStudy;
    private Integer groupStudyLectureIteration;
    private String groupStudyLectureTitle;
    private String groupStudyLectureContents;
    private LocalDate groupStudyLectureCreateAt;
    @OneToMany(mappedBy = "groupStudyLecture", fetch = FetchType.LAZY)
    private List<GroupStudyPost> groupStudyPostList;


    public GroupStudyLecture(GroupStudyLecturePostDTO dto) {
        this.groupStudy = dto.getGroupStudy();
        this.groupStudyLectureIteration = dto.getGroupStudyLectureIteration();
        this.groupStudyLectureTitle = dto.getGroupStudyLectureTitle();
        this.groupStudyLectureContents = dto.getGroupStudyLectureContents();
        this.groupStudyLectureCreateAt = dto.getGroupStudyLectureCreateAt();
    }
}
