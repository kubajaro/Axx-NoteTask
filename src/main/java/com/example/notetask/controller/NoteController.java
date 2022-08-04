package com.example.notetask.controller;

import com.example.notetask.entity.Note;
import com.example.notetask.repository.NoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/{id}")
    ResponseEntity<Note> findNoteById(@PathVariable int id) {
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<Note>> findAllNotes() {
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @PostMapping
    ResponseEntity<Note> saveNote(@RequestBody @Valid Note noteToSave) {
        return ResponseEntity.created(URI.create("/" + noteRepository.save(noteToSave).getId())).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody @Valid Note noteToUpdate) {
        if(!noteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        noteToUpdate.setId(id);
        noteRepository.save(noteToUpdate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Valid> deleteNoteById(@PathVariable int id) {
        if(!noteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
