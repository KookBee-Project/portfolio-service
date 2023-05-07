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
    private Long curriculumId;
    private String bootcampTitle;
    private Long teacherId;
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private String skillSetName; // skillSet 가져올 시 serialize 에러가 발생하여 skillSet중 필요한 정보만 가져옴

}
