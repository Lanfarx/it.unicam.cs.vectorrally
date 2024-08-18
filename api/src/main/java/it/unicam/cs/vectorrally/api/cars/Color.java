package it.unicam.cs.vectorrally.api.cars;

public enum Color {
    RED("\033[31m"),
    BLUE("\033[34m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    ORANGE("\033[38;5;208m"),
    MAGENTA("\033[35m"),
    PINK("\033[38;5;205m"),
    BROWN("\033[[38;5;94m");

    private final String color;

    Color(String colorCode) {
        this.color = colorCode;
    }

    public String getColor() {
        return color;
    }
}
