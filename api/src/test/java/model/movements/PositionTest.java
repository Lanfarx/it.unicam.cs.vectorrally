/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.movements;

import it.unicam.cs.vectorrally.api.model.movements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position p;

    @BeforeEach
    void setUp() {
        p = new Position(5,5);
    }

    @Test
    void getX() {
        assertEquals(5, p.getX());
    }

    @Test
    void getY() {
        assertEquals(5, p.getY());
    }

    @Test
    void setX(){
        p.setX(10);
        assertEquals(10, p.getX());
    }

    @Test
    void setY() {
        p.setY(10);
        assertEquals(10, p.getY());
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(p, p);
    }

    @Test
    void testEqualsSameValues() {
        Position samePosition = new Position(5, 5);
        assertEquals(p, samePosition);
    }

    @Test
    void testEqualsDifferent() {
        Position differentBoth = new Position(6, 6);
        assertNotEquals(p, differentBoth);
    }
}
