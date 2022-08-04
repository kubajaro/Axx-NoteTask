package com.example.notetask.repository;

import com.example.notetask.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlNoteRepository extends NoteRepository, JpaRepository<Note, Integer> {
}
