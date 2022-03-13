package com.csantos.tp1.repositoryandspecification.domain;

public interface Specification<T> {

    Specification<T> and(Specification<T> specification);
    Class<T> getType();
}
