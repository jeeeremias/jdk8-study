package com.study.java.utils.enums;

public enum Color {
    YELLOW,
    BLUE,
    BROWN,
    PINK,
    GREEN;

    public static int getTotalElements() {
        return values().length;
    }
}
