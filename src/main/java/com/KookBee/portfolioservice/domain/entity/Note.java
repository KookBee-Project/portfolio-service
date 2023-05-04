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
    private LocalDateTime createAt;
    private String UUID;
    private Long curriculumId;


    public Note(NoteCreateRequest request){
        this.title = request.getTitle();
        this.content = request.getContent();
        this.writerId = request.getWriterId();
        this.createAt = request.getCreateAt();
        this.UUID = request.getUUID();
        this.curriculumId = request.getCurriculumId();
    }
    public Note updateNote(NoteEditRequest request) {
        this.id = request.getId();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.UUID = request.getUUID();
        return this;
    }

}