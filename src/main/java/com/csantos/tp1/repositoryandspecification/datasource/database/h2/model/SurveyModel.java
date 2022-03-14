package com.csantos.tp1.repositoryandspecification.datasource.database.h2.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SurveyModel {

    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime lockDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<VoteModel> votes = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getLockDate() {
        return lockDate;
    }

    public void setLockDate(LocalDateTime lockDate) {
        this.lockDate = lockDate;
    }

    public List<VoteModel> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteModel> votes) {
        this.votes = votes;
    }
}
