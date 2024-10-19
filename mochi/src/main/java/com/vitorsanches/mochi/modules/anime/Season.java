package com.vitorsanches.mochi.modules.anime;

import lombok.Data;

public enum Season {
    FALL("fall"),
    WINTER("winter"),
    SPRING("spring"),
    SUMMER("summer");

    private final String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value;
    }
}
