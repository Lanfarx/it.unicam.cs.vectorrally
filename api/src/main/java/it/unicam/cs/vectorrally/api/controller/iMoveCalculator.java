package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.List;

public interface iMoveCalculator {
    /**
     * Obtains all the possible moves that can be chosen
     *
     * @param player the given player who is moving
     * @param raceTrack the track
     * @param players All the players currently in the track
     * @return the list of all the available moves
     */
    List<Move> availableMoves(Player player, RaceTrack raceTrack, List<Player> players);
}
