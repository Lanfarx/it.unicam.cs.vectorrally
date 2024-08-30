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
 * The {@code iMove} interface defines a contract for classes that represent a move
 * in the Vector Rally game. A move consists of an acceleration vector, a starting position,
 * and a new position after the move has been executed.
 */
public interface iMove {

    /**
     * Retrieves the acceleration vector associated with the move.
     *
     * @return A {@code Vector} representing the acceleration for this move.
     */
    Vector getAcceleration();

    /**
     * Retrieves the starting position of the move.
     *
     * @return A {@code Position} representing the starting position before the move is made.
     */
    Position getStartingPosition();

    /**
     * Retrieves the new position after the move has been executed,
     * based on the starting position and the acceleration vector.
     *
     * @return A {@code Position} representing the new position after the move.
     */
    Position getNewPosition();
}
