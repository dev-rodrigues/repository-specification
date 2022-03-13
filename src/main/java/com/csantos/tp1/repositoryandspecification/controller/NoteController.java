package com.csantos.tp1.repositoryandspecification.controller;

import com.csantos.tp1.repositoryandspecification.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllNotes() {
        var response = noteService.getAllNotes();
        return ResponseEntity.ok(response);
    }
}
