/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.movements;

import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    private Vector acceleration;
    private Position startPosition;
    private Move move;

    @BeforeEach
    void setUp() {
        acceleration = new Vector(2, 3);
        startPosition = new Position(5, 6);
        move = new Move(acceleration, startPosition);
    }

    @Test
    void testGetAcceleration() {
        assertEquals(acceleration, move.getAcceleration());
    }

    @Test
    void testGetStartingPosition() {
        assertEquals(startPosition, move.getStartingPosition());
    }

    @Test
    void testGetNewPosition() {
        Position expectedNewPosition = new Position(startPosition.getX() + acceleration.getAx(), startPosition.getY() + acceleration.getAy());
        assertEquals(expectedNewPosition, move.getNewPosition());
    }

    @Test
    void testGetNewPositionNegativeAcceleration() {
        Vector negativeAcceleration = new Vector(-2, -3);
        Move negativeMove = new Move(negativeAcceleration, startPosition);

        Position expectedNewPosition = new Position(startPosition.getX() + negativeAcceleration.getAx(), startPosition.getY() + negativeAcceleration.getAy());
        assertEquals(expectedNewPosition, negativeMove.getNewPosition());
    }

    @Test
    void testConstructorWithNullAcceleration() {
        assertThrows(NullPointerException.class, () -> new Move(null, startPosition));
    }

    @Test
    void testConstructorWithNullPosition() {
        assertThrows(NullPointerException.class, () -> new Move(acceleration, null));
    }
}