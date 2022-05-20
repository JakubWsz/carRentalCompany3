package com.kuba.carrentalcompany3.domain;

public interface UpdateFieldProcess<T> {
    void update(T object, String newValue);
}
