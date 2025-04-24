package com.practice.payment.mapper;

import java.util.List;

public abstract class BaseMapper<E,D> {

    public abstract E convertToEntity(D dto);

    public abstract D convertToDto(E entity);

    public List<E> convertToEntityList(List<D> dtos) {
        return dtos.stream().map(this::convertToEntity).toList();
    }

    public List<D> convertToDtoList(List<E> entities) {
        return entities.stream().map(this::convertToDto).toList();
    }

}