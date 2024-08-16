package it.unicam.cs.vectorrally.app.controller;

import it.unicam.cs.vectorrally.app.players.Player;
import it.unicam.cs.vectorrally.app.tracks.RaceTrack;

import java.util.List;

public class GameConfigurator implements iGameConfigurator {
    @Override
    public RaceTrack configTrack() {
        return null;
    }

    @Override
    public List<Player> configPlayers(RaceTrack raceTrack) {
        return List.of();
    }

    @Override
    public void configGame(List<Player> players, RaceTrack raceTrack) {

    }
}
