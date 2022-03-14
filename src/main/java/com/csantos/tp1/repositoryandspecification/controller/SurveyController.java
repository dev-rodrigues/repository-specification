package com.csantos.tp1.repositoryandspecification.controller;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel;
import com.csantos.tp1.repositoryandspecification.services.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SurveyModel>> get() {
        var resonse = surveyService.findBySpecification();
        return ResponseEntity.ok(resonse);
    }
}
