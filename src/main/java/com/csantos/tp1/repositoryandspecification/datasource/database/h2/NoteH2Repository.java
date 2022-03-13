package com.csantos.tp1.repositoryandspecification.datasource.database.h2;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.data.NoteData;
import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.NoteModel;
import com.csantos.tp1.repositoryandspecification.port.NotePort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteH2Repository implements NotePort{

    private final NoteData data;

    public NoteH2Repository(NoteData data) {
        this.data = data;
    }


    @Override
    public List<String> getAllNotes() {
        var response = data.findAll();
        return response.stream().map(NoteModel::getText).collect(java.util.stream.Collectors.toList());
    }
}
