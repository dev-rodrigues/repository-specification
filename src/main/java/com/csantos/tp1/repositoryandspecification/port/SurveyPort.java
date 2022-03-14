package com.csantos.tp1.repositoryandspecification.port;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel;
import com.csantos.tp1.repositoryandspecification.domain.Specification;

import javax.transaction.Transactional;
import java.util.List;

public interface SurveyPort {
    @Transactional
    void save(SurveyModel survey);

    <T> List<T> findBySpecification(Specification<T> specification);
}
