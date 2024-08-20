/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.cars;

import it.unicam.cs.vectorrally.api.movements.Vector;

/**
 * The {@code iCar} interface defines the basic functionality for a car object.
 * It includes methods to set and get the car's acceleration and to retrieve
 * the car's color.
 *  */
public interface iCar {

    /**
     * Sets the acceleration vector of the car.
     *
     * @param acceleration A {@code Vector} representing the acceleration to be set for the car.
     */
    void setAcceleration(Vector acceleration);

    /**
     * Gets the current acceleration vector of the car.
     *
     * @return A {@code Vector} representing the current acceleration of the car.
     */
    Vector getAcceleration();

    /**
     * Retrieves the color of the car.
     *
     * @return A {@code Color} object representing the color of the car.
     */
    Color getCarColor();
}
