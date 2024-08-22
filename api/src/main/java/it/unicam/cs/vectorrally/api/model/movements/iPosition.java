/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.movements;

/**
 * The {@code iPosition} interface defines a contract for classes that represent
 * a position in a 2D space with x and y coordinates. It includes methods to get
 * and set the x and y coordinates.
 */
public interface iPosition {

    /**
     * Retrieves the x coordinate of the position.
     *
     * @return An {@code int} representing the x coordinate.
     */
    int getX();

    /**
     * Retrieves the y coordinate of the position.
     *
     * @return An {@code int} representing the y coordinate.
     */
    int getY();

    /**
     * Sets the x coordinate of the position.
     *
     * @param x An {@code int} representing the new x coordinate.
     */
    void setX(int x);

    /**
     * Sets the y coordinate of the position.
     *
     * @param y An {@code int} representing the new y coordinate.
     */
    void setY(int y);
}
