package com.csantos.tp1.repositoryandspecification.datasource.database.h2;

import com.csantos.tp1.repositoryandspecification.datasource.database.h2.model.SurveyModel;
import com.csantos.tp1.repositoryandspecification.domain.Specification;
import com.csantos.tp1.repositoryandspecification.port.SurveyPort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SurveyH2Repository implements SurveyPort {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(SurveyModel survey) {
        this.em.persist(survey);
        this.em.flush();
    }

    @Override
    public <T> List<T> findBySpecification(Specification<T> specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(specification.getType());
        Root<T> root = criteriaQuery.from(specification.getType());

        Predicate predicate = specification.toPredicate(root, criteriaBuilder);

        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
