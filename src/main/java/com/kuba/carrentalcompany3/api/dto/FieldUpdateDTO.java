package com.kuba.carrentalcompany3.api.dto;

public class FieldUpdateDTO<T> {
    private final T fieldType;
    private final String newValue;

    public FieldUpdateDTO(T fieldType, String newValue) {
        this.fieldType = fieldType;
        this.newValue = newValue;
    }

    public T getFieldType() {
        return fieldType;
    }

    public String getNewValue() {
        return newValue;
    }
}
