package com.csantos.tp1.repositoryandspecification.services;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel;
import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.VoteModel;
import com.csantos.tp1.repositoryandspecification.domain.SurveyCurrentlyRunning;
import com.csantos.tp1.repositoryandspecification.port.SurveyPort;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private final SurveyPort surveyPort;

    public SurveyService(SurveyPort surveyPort) {
        this.surveyPort = surveyPort;
    }

    public List<SurveyModel> findBySpecification() {

        var survey = new SurveyModel();

        survey.setStartDate(LocalDateTime.now().minusDays(1));
        survey.setEndDate(LocalDateTime.now().plusDays(1));
        survey.setVotes(List.of(new VoteModel()));

        surveyPort.save(
                survey
        );


        return this.surveyPort.findBySpecification(new SurveyCurrentlyRunning());
    }
}
