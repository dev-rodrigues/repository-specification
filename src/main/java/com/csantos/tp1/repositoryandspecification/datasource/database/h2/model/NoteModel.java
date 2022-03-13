package com.csantos.tp1.repositoryandspecification.datasource.database.h2.model;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "note")
public class NoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    private DateTime createdAt;

    private DateTime updatedAt;

    public boolean estaAtivo() {
        return createdAt.isBeforeNow() && updatedAt == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
