package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.io.IOException;
import java.util.List;

public interface iGameConfigurator {

    /**
     * Configures the track for the game.
     *
     * @return the configured racetrack.
     */
    RaceTrack configTrack() throws IOException;

    /**
     * Configures the players (both bots and interactive) for the game.
     *
     * @param raceTrack where the playerCars will race against each-other
     * @return the list of the configured players for the game
     */;

    List<Player> configPlayers(RaceTrack raceTrack) throws IOException;
}
