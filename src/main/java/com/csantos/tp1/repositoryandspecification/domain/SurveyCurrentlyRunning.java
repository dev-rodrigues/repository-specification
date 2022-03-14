package com.csantos.tp1.repositoryandspecification.domain;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel;
import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel_;
import org.joda.time.LocalDateTime;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SurveyCurrentlyRunning extends AbstractSpecification<SurveyModel> {

    @Override
    public boolean isSatisfiedBy(SurveyModel surveyModel) {
        return surveyModel.getStartDate().isBefore(LocalDateTime.now())
                && surveyModel.getEndDate().isAfter(LocalDateTime.now())
                && surveyModel.getLockDate() == null;
    }

    @Override
    public Predicate toPredicate(Root<SurveyModel> root, CriteriaBuilder cb) {
        var date = LocalDateTime.now();
        return cb.and(
                cb.lessThan(root.get(SurveyModel_.startDate), date),
                cb.greaterThan(root.get(SurveyModel_.endDate), date),
                cb.isNull(root.get(SurveyModel_.lockDate))
        );
    }
}
