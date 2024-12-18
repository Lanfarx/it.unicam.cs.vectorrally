/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


/**
 * The {@code iColorUtils} interface provides utility methods for working with colors in the Vector Rally application.
 * Specifically, it contains a method for converting a custom {@link it.unicam.cs.vectorrally.api.model.cars.Color}
 * enumeration to a JavaFX {@link javafx.scene.paint.Paint} object.
 */
public interface iColorUtils {

    /**
     * Converts a {@link it.unicam.cs.vectorrally.api.model.cars.Color} enumeration value to a corresponding
     * JavaFX {@link javafx.scene.paint.Paint} object.
     *
     * @param colorEnum The {@link it.unicam.cs.vectorrally.api.model.cars.Color} value to convert.
     * @return The corresponding {@link javafx.scene.paint.Paint} object.
     */
    static Paint getPaintFromColor(it.unicam.cs.vectorrally.api.model.cars.Color colorEnum) {
        return switch (colorEnum) {
            case RED -> Color.RED;
            case BLUE -> Color.BLUE;
            case GREEN -> Color.GREEN;
            case YELLOW -> Color.YELLOW;
            case ORANGE -> Color.ORANGE;
            case MAGENTA -> Color.MAGENTA;
            case PINK -> Color.PINK;
            case BROWN -> Color.BROWN;
        };
    }
}
