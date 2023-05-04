package com.KookBee.portfolioservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortFolioStudyRegistRequest {
    private String studyName;
    private String studyPerpose;
    private List<Long> userIdList;

}
