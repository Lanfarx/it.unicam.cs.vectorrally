/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.movements;

/**
 * The {@code Move} class implements the {@code iMove} interface and represents a move in the game,
 * defined by an acceleration vector and a starting position. This class encapsulates the details
 * of a move, including how the move affects the position of a player.
 */
public class Move implements iMove {

    private final Vector acceleration;
    private final Position position;

    /**
     * Constructs a {@code Move} instance with the specified acceleration and starting position.
     *
     * @param acceleration the {@code Vector} representing the acceleration applied during the move
     * @param position the {@code Position} representing the starting position of the move
     * @throws NullPointerException if either {@code acceleration} or {@code position} is {@code null}
     */
    public Move(Vector acceleration, Position position) {
        if (acceleration == null || position == null) {
            throw new NullPointerException("Acceleration and position cannot be null");
        }
        this.acceleration = acceleration;
        this.position = position;
    }

    @Override
    public Vector getAcceleration() {
        return this.acceleration;
    }

    @Override
    public Position getStartingPosition() {
        return this.position;
    }

    @Override
    public Position getNewPosition() {
       return new Position(this.position.getX() + this.acceleration.getAx(), this.position.getY() + this.acceleration.getAy());
    }
}
