package com.csantos.tp1.repositoryandspecification.services;

import com.csantos.tp1.repositoryandspecification.port.NotePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NotePort port;

    // especifica qual o tipo de repository que será utilizado
    public NoteService(@Qualifier("noteMemoryRepository") NotePort port) {
        this.port = port;
    }


    public List<String> getAllNotes() {
        return port.getAllNotes();
    }
}
