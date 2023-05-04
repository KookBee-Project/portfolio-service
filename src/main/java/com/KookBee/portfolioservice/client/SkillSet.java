package com.KookBee.portfolioservice.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SkillSet {
    private Long id;
    private String skillSetName;
    private List<Curriculum> curriculumList;
}
