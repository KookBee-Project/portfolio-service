package com.KookBee.portfolioservice.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Curriculum {
    private Long id;
    private Bootcamp bootcamp;
    private Long teacherId; // teacher table nono user table id OO
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private SkillSet skillSet;

}
