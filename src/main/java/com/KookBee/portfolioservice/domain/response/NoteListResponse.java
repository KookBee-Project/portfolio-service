package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteListResponse {
    private String noteTitle;
    private LocalDateTime createAt;
    private String skillSetName;
    private String noteId;

    public NoteListResponse(Note el, String skillSetName) {
        this.noteId = el.getId();
        if(el.getTitle().length() >= 15) this.noteTitle = el.getTitle().substring(0, 14) + "...";
        else this.noteTitle = el.getTitle();
        this.createAt = el.getCreateAt();
        this.skillSetName = skillSetName;
    }
}
