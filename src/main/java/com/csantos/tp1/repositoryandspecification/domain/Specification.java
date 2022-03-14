package com.csantos.tp1.repositoryandspecification.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Specification<T> {

    boolean isSatisfiedBy(T t);
    Predicate toPredicate(Root<T> root, CriteriaBuilder cb);
    Specification<T> and(Specification<T> specification);
    Class<T> getType();
}
