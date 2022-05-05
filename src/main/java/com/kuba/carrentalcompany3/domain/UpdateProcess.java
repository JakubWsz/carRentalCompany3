package com.kuba.carrentalcompany3.domain;

import java.util.function.Predicate;

public interface UpdateProcess<T> {
    void update(Predicate<T> check, Runnable action);
}
