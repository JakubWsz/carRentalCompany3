package com.kuba.carrentalcompany3.domain.exception;

public enum CarExceptionCode implements ExceptionCode {
    BRAND_CANT_BE_NULL("Ca_001", "Pole z marką nie może być puste.", 409),
    MODEL_CANT_BE_NULL("Ca_002", "Pole z modelem nie może być puste.", 409),
    CAR_TYPE_CANT_BE_NULL("Ca_003", "Pole z nadwoziem nie może być puste.", 409),
    FUEL_TYPE_CANT_BE_NULL("Ca_004", "Pole z paliwem nie może być puste.", 409),
    GEARBOX_TYPE_CANT_BE_NULL("Ca_005", "Pole ze skrzynią biegów nie może być puste.", 409),
    DOOR_NUMBER_TYPE_CANT_BE_NULL("Ca_006", "Pole z liczbą drzwi nie może być puste.", 409),
    BOOT_CAPACITY_CANT_BE_NULL("Ca_007", "Pole z pojemnością bagarznika nie może być puste.", 409),
    OFFICE_ID_CANT_BE_NULL("Ca_008", "Pole z identyfikatorem biura nie może być puste.", 409);

    private final String code;
    private final String message;
    private final int status;

    CarExceptionCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return status;
    }
    }
