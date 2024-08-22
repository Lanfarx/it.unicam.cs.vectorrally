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
 * The {@code iVector} interface defines a contract for classes that represent
 * a direction vector with x and y acceleration components. It includes methods to get
 * and set the acceleration values as well as to retrieve the direction of the vector.
 */
public interface iVector {

    /**
     * Retrieves the x component of the acceleration vector.
     *
     * @return An {@code int} representing the x component of the acceleration vector.
     */
    int getAx();

    /**
     * Retrieves the y component of the acceleration vector.
     *
     * @return An {@code int} representing the y component of the acceleration vector.
     */
    int getAy();

    /**
     * Sets the x component of the acceleration vector.
     *
     * @param x An {@code int} representing the new x component of the acceleration vector.
     */
    void setAx(int x);

    /**
     * Sets the y component of the acceleration vector.
     *
     * @param y An {@code int} representing the new y component of the acceleration vector.
     */
    void setAy(int y);

    /**
     * Retrieves the direction of the vector.
     *
     * @return A {@code MoveDirection} representing the direction of the vector.
     */
    MoveDirection getDirection();
}