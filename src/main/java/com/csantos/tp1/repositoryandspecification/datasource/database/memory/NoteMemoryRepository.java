package com.csantos.tp1.repositoryandspecification.datasource.database.memory;

import com.csantos.tp1.repositoryandspecification.port.NotePort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteMemoryRepository implements NotePort {

    private List<String> notes = List.of("Note 3", "Note 2", "Note 1");

    @Override
    public List<String> getAllNotes() {
        return notes;
    }
}
