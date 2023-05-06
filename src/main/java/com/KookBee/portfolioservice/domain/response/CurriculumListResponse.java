package com.KookBee.portfolioservice.domain.response;
import com.KookBee.portfolioservice.client.Curriculum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumListResponse {
    private Long curriculumId;
    private String curriculumName;
    private String skillSetName;
    private String teacherName;
    private String curriculumStartDate;
    private String curriculumEndDate;


    public CurriculumListResponse(Curriculum el, String teacherName ) {

        this.curriculumId = el.getId();
        this.curriculumName = el.getCurriculumName();
        this.skillSetName = el.getSkillSet().getSkillSetName();
        this.teacherName = teacherName;
        this.curriculumStartDate = el.getCurriculumStartDate();
        this.curriculumEndDate = el.getCurriculumEndDate();
    }
}
