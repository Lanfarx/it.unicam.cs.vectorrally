/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.List;

/**
 * The {@code iGameController} interface defines the contract for controllers
 * managing the game in the Vector Rally application. It provides methods for
 * starting the game, managing player turns, handling eliminations, and determining
 * game outcomes.
 */
public interface iGameController {

    /**
     * Starts the game with the specified race track and players.
     *
     * This method initializes and starts the game using the provided race track and
     * list of players. It manages the overall game flow and coordinates game events.
     *
     * @param raceTrack A {@code RaceTrack} representing the track on which the game is played.
     * @param players A {@code List<Player>} containing all the players participating in the game.
     * @throws Exception if an error occurs while starting the game.
     */
    void startGame(RaceTrack raceTrack, List<Player> players) throws Exception;

    /**
     * Runs the main game loop, managing the game flow and interactions.
     *
     * This method contains the primary game loop that controls the sequence of turns,
     * manages game events, and ensures the game progresses correctly.
     *
     * @throws Exception if an error occurs while running the game.
     */
    void run() throws Exception;

    /**
     * Manages the turn for the specified player.
     *
     * This method handles the actions and decisions for the given player during their turn,
     * including processing moves and updating the game state.
     *
     * @param player A {@code Player} whose turn is being managed.
     * @throws Exception if an error occurs while processing the player's turn.
     */
    void playerTurn(Player player) throws Exception;

    /**
     * Manages the elimination of the specified player from the game.
     *
     * This method handles the process of removing a player from the game.
     *
     * @param player A {@code Player} who needs to be removed from the game.
     * @throws Exception if an error occurs while eliminating the player.
     */
    void playerElimination(Player player) throws Exception;

    /**
     * Ends the game and performs any necessary cleanup.
     *
     * This method finalizes the game, showing the end message.
     *
     * @throws Exception if an error occurs while ending the game.
     */
    void endGame() throws Exception;
}
