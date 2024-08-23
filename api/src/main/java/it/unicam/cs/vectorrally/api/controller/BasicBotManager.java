/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.model.movements.Move;

import java.util.List;
import java.util.Random;

/**
 * This class provides a basic implementation of the {@link iBotManager} interface,
 * which is responsible for managing bot players in the game.
 * The {@code BasicBotManager} randomly determines the next move for a bot from a list of available moves.
 */
public class BasicBotManager implements iBotManager{
    private final Random rand;

    /**
     * Constructs a {@code BasicBotManager} with a new random value generator.
     */
    public BasicBotManager() {
        this.rand = new Random();
    }

    @Override
    public Move nextMove(List<Move> availableMoves) {
        int randomMoveIndex = rand.nextInt(availableMoves.size());
        return availableMoves.get(randomMoveIndex);
    }
}
