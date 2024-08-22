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
import it.unicam.cs.vectorrally.api.model.players.Player;

import java.util.List;
import java.util.Random;

/**
 * The {@code BotManager} class provides functionality to manage bot behaviors in a racing game.
 * It is responsible for determining the next move for a bot player from a list of available moves.
 */
public class BotManager {

    /**
     * Determines the next move for a given bot player by randomly selecting one of the available moves.
     *
     * @param bot the {@code Player} instance representing the bot for which the move is to be determined
     * @param availableMoves a {@code List<Move>} containing all possible moves that the bot can choose from
     * @return the {@code Move} instance that represents the bot's next move, randomly selected from the available moves
     */
    public Move nextMove(Player bot, List<Move> availableMoves) {
        Random rand = new Random();
        int randomMoveIndex = rand.nextInt(availableMoves.size());
        return availableMoves.get(randomMoveIndex);
    }
}
