package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.List;

public interface iUIRaceController extends iUIController {

    /**
     * Displays the actual track
     *
     * @param raceTrack the racetrack to be displayed
     * @param players the list of all the players
     */
    void displayTrack(RaceTrack raceTrack, List<Player> players);

    /**
     * Chooses the track files
     *
     * @return the chosen track file
     */

    int chooseTrack();

    /**
     * Chooses the number of Bot players in the game
     *
     * @return the number of Bot players
     */

    int chooseBots();

    /**
     * Chooses the number of Interactive players in the game
     *
     * @param numPlayers the number of Interactive players
     * @return the number of Interactive players
     */
    int chooseNumPlayers(int numPlayers);

    /**
     * Makes a player choose a car color.
     *
     * @param colors the list of colors
     * @return the chosen color
     */
    Color chooseColor(List<Color> colors);

    /**
     * Makes a player choose his next move
     *
     * @param moves the valid moves
     */
    Move chooseNextMove(List<Move> moves);

    /**
     * Displays the turn of the player
     *
     * @param player the player whose turn is
     */
    void displayPlayerTurn(Player player);

    /**
     * Displays the elimination of the given player
     *
     * @param player the player who is eliminated
     */
    void displayPlayerElimination(Player player);

    /**
     * Displays the victory of the given player
     *
     * @param player the player who has won
     */
    void displayVictory(Player player);

}
