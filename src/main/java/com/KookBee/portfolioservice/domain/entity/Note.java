package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.request.NoteCreateRequest;
import com.KookBee.portfolioservice.domain.request.NoteEditRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "post")
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    private Long writerId;
    private LocalDateTime createAt = LocalDateTime.now();
    private String uuid;
    private Long curriculumId;

    public Note createNote(NoteCreateRequest request, Long id){
        this.title = request.getTitle();
        this.content = request.getContent();
        this.writerId = id;
        this.uuid = request.getUuid();
        this.curriculumId = request.getCurriculumId();
        return this;
    }
    public Note updateNote(NoteEditRequest request) {
        this.id = request.getId();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.uuid = request.getUuid();
        return this;
    }

}