package com.example.notetask.repository;

import com.example.notetask.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> findAll();

    Optional<Note> findById(Integer integer);

    Note save(Note note);

    boolean existsById(Integer id);

    void deleteById(Integer integer);
}
