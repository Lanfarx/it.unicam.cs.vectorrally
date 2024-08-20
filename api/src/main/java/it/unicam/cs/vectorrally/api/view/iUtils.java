/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

/**
 * The {@code iUtils} interface provides utility methods for printing text to the
 * Command Line Interface (CLI). It includes methods for printing regular and colored
 * text, with or without a newline.
 */
public interface iUtils {

    /**
     * Prints the given text to the CLI without a newline.
     *
     * @param text A {@code String} representing the text to be printed.
     */
    static void printText(String text) {
        System.out.print(text);
    }

    /**
     * Prints the given text to the CLI and starts a new line.
     *
     * @param text A {@code String} representing the text to be printed.
     */
    static void printlnText(String text) {
        System.out.println(text);
    }

    /**
     * Prints the given text in a specified color to the CLI without a newline.
     *
     * @param text  A {@code String} representing the text to be printed.
     * @param color A {@code String} representing the color code to apply to the text.
     */
    static void printTextColored(String text, String color) {
        printText(color + text + "\033[0m");
    }

    /**
     * Prints the given text in a specified color to the CLI and starts a new line.
     *
     * @param text  A {@code String} representing the text to be printed.
     * @param color A {@code String} representing the color code to apply to the text.
     */
    static void printlnTextColored(String text, String color) {
        printlnText(color + text + "\033[0m");
    }
}
