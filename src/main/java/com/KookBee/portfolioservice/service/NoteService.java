package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.ClassServiceClient;
import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.entity.Note;
import com.KookBee.portfolioservice.domain.request.NoteCreateRequest;
import com.KookBee.portfolioservice.domain.response.NoteDetailResponse;
import com.KookBee.portfolioservice.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserServiceClient userServiceClient;
    private final ClassServiceClient classServiceClient;
    public Note createNote(NoteCreateRequest request) {
        Note newNote = new Note(request);
        return noteRepository.save(newNote);
    }
    public NoteDetailResponse getNote(Long curriculumId, Long writerId) {

    }
}
