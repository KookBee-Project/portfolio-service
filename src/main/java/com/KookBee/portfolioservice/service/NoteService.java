package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.ClassServiceClient;
import com.KookBee.portfolioservice.client.Curriculum;
import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.entity.Note;
import com.KookBee.portfolioservice.domain.request.NoteCreateRequest;
import com.KookBee.portfolioservice.domain.request.NoteEditRequest;
import com.KookBee.portfolioservice.domain.response.CurriculumListResponse;
import com.KookBee.portfolioservice.domain.response.NoteListResponse;
import com.KookBee.portfolioservice.repository.NoteRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserServiceClient userServiceClient;
    private final ClassServiceClient classServiceClient;
    private final JwtService jwtService;
    public Note createNote(NoteCreateRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Note newNote = new Note().createNote(request, userId);
        return noteRepository.save(newNote);
    }
    public List<CurriculumListResponse> getCurriculumList() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Curriculum> curriculumByUserId = classServiceClient.getCurriculumByUserId(userId);
        return curriculumByUserId.stream().map(el -> {
            String teacherName = userServiceClient.getUserById(el.getTeacherId()).getUserName();
            return new CurriculumListResponse(el, teacherName);
        }).toList();
    }
    public List<NoteListResponse> getNoteList(Long curriculumId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Note> noteList = noteRepository.findAllByCurriculumIdAndWriterId(curriculumId, userId);
        return noteList.stream().map(el-> {
            String skillSetName =  classServiceClient.getCurriculumByCurriculumId(curriculumId).getSkillSetName();
            return new NoteListResponse(el, skillSetName);
        }).toList();
    }
    public Note updateNote(NoteEditRequest request) {
        Note note = noteRepository.findById(request.getId()).orElse(null);
        assert(note!= null);
        return noteRepository.save(note.updateNote(request));

    }

    public Note getNoteDetail(String id) {
        Note note = noteRepository.findById(id).orElse(null);
        assert (note!=null);
        return note;
    }
}
