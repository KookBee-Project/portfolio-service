package com.KookBee.portfolioservice.domain.response.noteResponse;

import com.KookBee.portfolioservice.domain.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDetailResponse {
    private String id;
    private String title;
    private String content;
    private String writerName;
    private LocalDateTime createAt;
    private String UUID;
    private String skillSetName;

    public NoteDetailResponse(Note note, String writerName, String skillSetName) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.writerName = writerName;
        this.createAt = note.getCreateAt();
        this.UUID = note.getUUID();
        this.skillSetName = skillSetName;
    }
}
