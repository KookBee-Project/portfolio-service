package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.entity.Note;
import com.KookBee.portfolioservice.domain.request.NoteCreateRequest;
import com.KookBee.portfolioservice.domain.response.CurriculumListResponse;
import com.KookBee.portfolioservice.domain.response.NoteDetailResponse;
import com.KookBee.portfolioservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @PostMapping("")
    public Note createNote(NoteCreateRequest request){
        return noteService.createNote(request);
    }
    @GetMapping("/{curriculumId}/{noteId}")
    public List<CurriculumListResponse> getDetailNote(
            @PathVariable Long curriculumId,
            @PathVariable Long noteId)
    {

    }


}
