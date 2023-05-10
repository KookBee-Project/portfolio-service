package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findAllByCurriculumIdAndWriterId(Long curriculumId, Long writerId);
}
