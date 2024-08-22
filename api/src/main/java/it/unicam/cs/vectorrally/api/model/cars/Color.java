/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.cars;

/**
 * The {@code Color} enum represents a set of predefined colors, each associated with a specific ANSI escape code
 * for terminal text color formatting. This enum allows for easy use of standard and extended colors in terminal output.
 */
public enum Color {
    RED("\033[31m"),
    BLUE("\033[34m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    ORANGE("\033[38;5;208m"),
    MAGENTA("\033[35m"),
    PINK("\033[38;5;205m"),
    BROWN("\033[38;5;94m");

    private final String color;

    /**
     * Constructs a {@code Color} enum constant with the specified ANSI escape code.
     *
     * @param colorCode the ANSI escape code for the color
     */
    Color(String colorCode) {
        this.color = colorCode;
    }

    /**
     * Gets the ANSI escape code associated with this color.
     *
     * @return a {@code String} representing the ANSI escape code for the color
     */
    public String getColor() {
        return color;
    }
}