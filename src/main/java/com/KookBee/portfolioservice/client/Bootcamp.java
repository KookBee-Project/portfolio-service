package com.KookBee.portfolioservice.client;


import java.util.List;

public class Bootcamp {
    private Long id;
    private Long companyId;
    private Long campusId;
    private Long managerId; // userId
    private String bootcampTitle;
    private String bootcampDescription;
    private List<Curriculum> curriculumList;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String bootcampEnterCode;
    private List<StudentBootcamp> studentBootcampList;

}
