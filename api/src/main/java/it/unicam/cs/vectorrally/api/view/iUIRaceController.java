/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;

import java.util.List;

/**
 * The {@code iUIRaceController} interface extends {@code iUIController} and defines
 * a contract for classes that manage the user interface for Vector Rally games. It includes
 * methods for displaying the game track, choosing game settings, and handling player interactions.
 */
public interface iUIRaceController extends iUIController {

    /**
     * Displays the current state of the racetrack along with the players' positions.
     *
     * @param raceTrack A {@code RaceTrack} representing the track to be displayed.
     * @param players A {@code List<Player>} containing all the players in the game.
     */
    void displayTrack(RaceTrack raceTrack, List<Player> players);

    void displayInvalidTrackFile();

    /**
     * Prompts the user to choose a track file from the directory and returns the selected track file number.
     *
     * @return An {@code int} representing the number of the selected track file.
     */
    int chooseTrack();

    /**
     * Prompts the user to choose a bot file from the directory and returns the selected bot file number.
     *
     * @return An {@code int} representing the number of the selected bot file.
     */
    int chooseBots();

    /**
     * Displays the turn information for the specified player.
     *
     * @param player A {@code Player} whose turn is being displayed.
     */
    void displayPlayerTurn(Player player);

    /**
     * Displays the move made by a player.
     *
     * @param player The {@code Player} who made the move.
     * @param move The {@code Move} that the player made.
     */
    void displayPlayerMove(Player player, Move move);

    /**
     * Displays a message indicating that the specified player has been eliminated.
     *
     * @param player A {@code Player} who has been eliminated from the game.
     */
    void displayPlayerElimination(Player player);

    /**
     * Displays a message indicating that the specified player has won the game.
     *
     * @param player A {@code Player} who has won the game.
     */
    void displayVictory(Player player);
}
