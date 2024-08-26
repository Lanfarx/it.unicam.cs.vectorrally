/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.players;

import it.unicam.cs.vectorrally.api.model.cars.Car;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.cars.Color;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(Color.RED);
        player = new Player(testCar){};
    }

    @Test
    void testConstructorWithNullCarThrowsException() {
        assertThrows(NullPointerException.class, () -> new Player(null){}, "PlayerCar can't be null");
    }

    @Test
    void testSetPlayerAccelerationWithValidVector() {
        Vector acceleration = new Vector(1, 2);
        player.setPlayerAcceleration(acceleration);
        assertTrue(equalsAccelerations(acceleration, player.getPlayerAcceleration()));
    }

    private boolean equalsAccelerations(Vector acceleration, Vector playerAcceleration) {
        return acceleration.getAx() == playerAcceleration.getAx() && acceleration.getAy() == playerAcceleration.getAy();
    }

    @Test
    void testSetPlayerAccelerationWithNullThrowsException() {
        assertThrows(NullPointerException.class, () -> player.setPlayerAcceleration(null), "Acceleration can't be null");
    }

    @Test
    void testGetPlayerCarColor() {
        assertEquals(Color.RED, player.getPlayerCarColor());
    }

    @Test
    void testGetPosition() {
        assertEquals(new Position(0, 0), player.getPosition());
    }

    @Test
    void testSetPositionWithValidPosition() {
        Position newPosition = new Position(5, 5);
        player.setPosition(newPosition);
        assertEquals(newPosition, player.getPosition());
    }

    @Test
    void testSetPositionWithNullThrowsException() {
        assertThrows(NullPointerException.class, () -> player.setPosition(null), "PlayerPosition can't be null");
    }
}