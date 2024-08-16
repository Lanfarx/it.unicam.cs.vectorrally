package it.unicam.cs.vectorrally.app.controller;

import it.unicam.cs.vectorrally.app.players.Player;
import it.unicam.cs.vectorrally.app.tracks.RaceTrack;

import java.util.List;

public interface iGameConfigurator {

    /**
     * Configures the track for the game.
     *
     * @return the configured racetrack.
     */
    RaceTrack configTrack();

    /**
     * Configures the players (both bots and interactive) for the game.
     *
     * @param raceTrack where the playerCars will race against each-other
     * @return the list of the configured players for the game
     */
    List<Player> configPlayers(RaceTrack raceTrack);

    /**
     * Configures the game with the given players and racetrack
     *
     * @param players the configured players for the game
     * @param raceTrack where the playerCars will race against each-other
     */
    void configGame(List<Player> players, RaceTrack raceTrack);
}
