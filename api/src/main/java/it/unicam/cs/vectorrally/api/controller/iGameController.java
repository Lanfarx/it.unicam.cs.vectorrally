package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.List;

public interface iGameController {

    /**
     * Starts the game and controls it
     *
     * @throws Exception if something goes wrong
     */

    void startGame(List<Player> players,RaceTrack raceTrack) throws Exception;

    /**
     * Manage a turn for the given player
     *
     * @param player the player whose turn is
     * @throws Exception if something goes wrong
     */
    void playerTurn(Player player) throws Exception;

    /**
     * Manage the elimination of the given player
     *
     * @param player the player who needs to be removed from the game
     * @throws Exception if something goes wrong
     */
    void playerElimination(Player player) throws Exception;
}
