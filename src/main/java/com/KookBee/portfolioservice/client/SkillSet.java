package com.KookBee.portfolioservice.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class SkillSet {
    private Long id;
    private String skillSetName;
    private List<Curriculum> curriculumList;
}
