package com.KookBee.portfolioservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NoteEditRequest {
    private String id;
    private String title;
    private String content;
    private Long writerId;
    private LocalDateTime createAt;
    private String UUID;
    private Long curriculumId;
}
