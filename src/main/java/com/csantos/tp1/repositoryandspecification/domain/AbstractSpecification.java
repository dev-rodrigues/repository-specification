package com.csantos.tp1.repositoryandspecification.domain;

import java.lang.reflect.ParameterizedType;


abstract public class AbstractSpecification<T> implements Specification<T> {

    @Override
    public Specification<T> and(Specification<T> other) {
        return new And<>(this, other);
    }

    @Override
    public Class<T> getType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>)type.getActualTypeArguments()[0];
    }
}
