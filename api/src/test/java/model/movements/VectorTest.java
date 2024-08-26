/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.movements;

import it.unicam.cs.vectorrally.api.model.movements.Vector;
import it.unicam.cs.vectorrally.api.model.movements.MoveDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    private Vector vector;

    @BeforeEach
    void setUp() {
        vector = new Vector(2, 3);
    }

    @Test
    void testConstructor() {
        assertEquals(2, vector.getAx());
        assertEquals(3, vector.getAy());
    }

    @Test
    void testGetAx() {
        assertEquals(2, vector.getAx());
    }

    @Test
    void testGetAy() {
        assertEquals(3, vector.getAy());
    }

    @Test
    void testSetAx() {
        vector.setAx(10);
        assertEquals(10, vector.getAx());
    }

    @Test
    void testSetAy() {
        vector.setAy(20);
        assertEquals(20, vector.getAy());
    }

    @Test
    void testGetDirectionNone() {
        vector = new Vector(0, 0);
        assertEquals(MoveDirection.NONE, vector.getDirection());
    }

    @Test
    void testGetDirectionUp() {
        vector = new Vector(0, 1);
        assertEquals(MoveDirection.UP, vector.getDirection());
    }

    @Test
    void testGetDirectionDown() {
        vector = new Vector(0, -1);
        assertEquals(MoveDirection.DOWN, vector.getDirection());
    }

    @Test
    void testGetDirectionRight() {
        vector = new Vector(1, 0);
        assertEquals(MoveDirection.RIGHT, vector.getDirection());
    }

    @Test
    void testGetDirectionLeft() {
        vector = new Vector(-1, 0);
        assertEquals(MoveDirection.LEFT, vector.getDirection());
    }

    @Test
    void testGetDirectionUpRight() {
        vector = new Vector(1, 1);
        assertEquals(MoveDirection.UP_RIGHT, vector.getDirection());
    }

    @Test
    void testGetDirectionUpLeft() {
        vector = new Vector(-1, 1);
        assertEquals(MoveDirection.UP_LEFT, vector.getDirection());
    }

    @Test
    void testGetDirectionDownRight() {
        vector = new Vector(1, -1);
        assertEquals(MoveDirection.DOWN_RIGHT, vector.getDirection());
    }

    @Test
    void testGetDirectionDownLeft() {
        vector = new Vector(-1, -1);
        assertEquals(MoveDirection.DOWN_LEFT, vector.getDirection());
    }
}