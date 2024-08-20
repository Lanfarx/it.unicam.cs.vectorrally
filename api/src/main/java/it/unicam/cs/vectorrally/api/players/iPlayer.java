/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.players;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.movements.Vector;

/**
 * The {@code iPlayer} interface defines a contract for classes that represent a player in a racing game.
 * This interface includes methods for managing the player's acceleration, car color, and position on the track.
 */
public interface iPlayer {

    /**
     * Sets the acceleration of the player.
     *
     * @param acceleration A {@code Vector} representing the new acceleration of the player.
     * @throws NullPointerException if the provided acceleration is {@code null}.
     */
    void setPlayerAcceleration(Vector acceleration);

    /**
     * Retrieves the acceleration of the player.
     *
     * @return A {@code Vector} representing the current acceleration of the player.
     */
    Vector getPlayerAcceleration();

    /**
     * Retrieves the color of the player's car.
     *
     * @return A {@code Color} representing the color of the player's car.
     */
    Color getPlayerCarColor();

    /**
     * Retrieves the current position of the player on the track.
     *
     * @return A {@code Position} representing the player's current position.
     */
    Position getPosition();

    /**
     * Sets the position of the player on the track.
     *
     * @param position A {@code Position} representing the new position of the player on the track.
     * @throws NullPointerException if the provided position is {@code null}.
     */
    void setPosition(Position position);
}
