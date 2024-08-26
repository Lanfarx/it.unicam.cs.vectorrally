/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.cars;

import it.unicam.cs.vectorrally.api.model.cars.Car;
import it.unicam.cs.vectorrally.api.model.cars.Color;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;
    private Color color;

    @BeforeEach
    void setUp() {
        color = Color.RED;
        car = new Car(color);
    }

    @Test
    void testConstructorWithValidColor() {
        assertNotNull(car);
        assertEquals(color, car.getCarColor());
    }

    @Test
    void testConstructorWithNullColor() {
        assertThrows(NullPointerException.class, () -> new Car(null));
    }

    @Test
    void testInitialAcceleration() {
        Vector initialAcceleration = car.getAcceleration();
        assertEquals(0, initialAcceleration.getAx());
        assertEquals(0, initialAcceleration.getAy());
    }

    @Test
    void testSetAndGetAcceleration() {
        Vector newAcceleration = new Vector(2, 3);
        car.setAcceleration(newAcceleration);
        Vector acceleration = car.getAcceleration();
        assertEquals(2, acceleration.getAx());
        assertEquals(3, acceleration.getAy());
    }

    @Test
    void testSetAccelerationWithNull() {
        assertThrows(NullPointerException.class, () -> car.setAcceleration(null));
    }

    @Test
    void testGetCarColor() {
        assertEquals(color, car.getCarColor());
    }
}