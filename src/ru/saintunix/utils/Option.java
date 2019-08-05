package ru.saintunix.utils;

import java.util.NoSuchElementException;

public class Option<T> {
    private T value;

    public Option(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null)
            throw new NoSuchElementException();

        return value;
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public boolean isPresent() {
        return value != null;
    }
}
