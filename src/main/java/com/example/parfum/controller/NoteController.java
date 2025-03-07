package com.example.parfum.controller;

import com.example.parfum.dto.NoteDto;
import com.example.parfum.model.Note;
import com.example.parfum.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody NoteDto noteDto) {
        Note note = new Note();
        note.setName(noteDto.getName());
        note.setPourcentage(noteDto.getPourcentage());
        note.setPrice(noteDto.getPrice());

        Note _note = noteRepository.save(note);
        return ResponseEntity.ok(_note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = noteRepository.findAll();

        return ResponseEntity.ok(notes);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody NoteDto noteDto) {
        Note note = noteRepository.findById(noteDto.getId()).orElse(null);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }

        note.setName(noteDto.getName());
        note.setPourcentage(noteDto.getPourcentage());
        note.setPrice(noteDto.getPrice());

        Note _note = noteRepository.save(note);
        return ResponseEntity.ok(_note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
