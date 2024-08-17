package it.unicam.cs.vectorrally.api.cars;

public enum Color {
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    ORANGE("\u001B[38;5;208m"),
    MAGENTA("\u001B[35m"),
    PINK("\u001B[38;5;205m"),
    BROWN("\u001B[[38;5;94m"),;

    private final String color;

    Color(String colorCode) {
        this.color = colorCode;
    }

    public String getColor() {
        return color;
    }
}
