package com.csantos.tp1.repositoryandspecification.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class And<T> extends AbstractSpecification<T> {

    private final Specification<T> first;
    private final Specification<T> second;

    public And(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return first.isSatisfiedBy(t) && second.isSatisfiedBy(t);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaBuilder cb) {
        return cb.and(first.toPredicate(root, cb), second.toPredicate(root, cb));
    }

    @Override
    public Class<T> getType() {
        return first.getType();
    }
}
