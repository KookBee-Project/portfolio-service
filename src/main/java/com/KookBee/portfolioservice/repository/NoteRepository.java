package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
