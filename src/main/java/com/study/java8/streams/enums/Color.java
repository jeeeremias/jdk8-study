package com.study.java8.streams.enums;

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
