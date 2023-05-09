package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.entity.Note;
import com.KookBee.portfolioservice.domain.request.NoteCreateRequest;
import com.KookBee.portfolioservice.domain.request.NoteEditRequest;
import com.KookBee.portfolioservice.domain.response.CurriculumListResponse;
import com.KookBee.portfolioservice.domain.response.NoteDetailResponse;
import com.KookBee.portfolioservice.domain.response.NoteListResponse;
import com.KookBee.portfolioservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio/note")
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody NoteCreateRequest request){
        return noteService.createNote(request);
    }
    @GetMapping("")
    public List<CurriculumListResponse> getCurriculum() {
        return noteService.getCurriculumList();
    }
    @GetMapping("/list/{curriculumId}")
    public List<NoteListResponse> getNoteList(@PathVariable("curriculumId") Long curriculumId) {
        return noteService.getNoteList(curriculumId);
    }
    @PutMapping
    public Note updateNote(@RequestBody NoteEditRequest request){
        return noteService.updateNote(request);
    }
    @GetMapping("/{noteId}")
    public Note getDetailNote(@PathVariable String noteId) {
        return noteService.getNoteDetail(noteId);
    }

}
