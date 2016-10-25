package com.study.java8.enums;

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
