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
 * The {@code Car} class implements the {@code iCar} interface and represents a car with a color and acceleration vector.
 * This class provides the functionality to set and get the color and acceleration of the car.
 */
public class Car implements iCar {

    private final Color color;
    private final Vector accelerationCar;

    /**
     * Constructs a {@code Car} with the specified color and initializes its acceleration to zero.
     *
     * @param color the {@code Color} representing the color of the car
     * @throws NullPointerException if {@code color} is {@code null}
     */
    public Car(Color color) {
        if (color == null) {
            throw new NullPointerException("Color can't be null");
        }
        this.color = color;
        this.accelerationCar = new Vector(0, 0);
    }

    @Override
    public void setAcceleration(Vector acceleration) {
        if(acceleration == null) throw new NullPointerException("Acceleration can't be null");
        this.accelerationCar.setAx(acceleration.getAx());
        this.accelerationCar.setAy(acceleration.getAy());
    }

    @Override
    public Vector getAcceleration() {
        return accelerationCar;
    }

    @Override
    public Color getCarColor() {
        return color;
    }
}
