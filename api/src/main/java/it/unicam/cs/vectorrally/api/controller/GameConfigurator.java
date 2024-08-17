package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.view.UIController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameConfigurator implements iGameConfigurator {
    private final UIController controller;
    private final RaceTrackReader raceTrackReader;
    private final BotReader botReader;


    public GameConfigurator(UIController controller, RaceTrackReader rtr, BotReader br, UIController controller1, RaceTrackReader raceTrackReader, BotReader botReader) {
        this.controller = controller1;
        this.raceTrackReader = raceTrackReader;
        this.botReader = botReader;
    }

    @Override
    public RaceTrack configTrack() throws IOException {
        String track = "filepath";
        return raceTrackReader.createTrack(track);
    }

    @Override
    public List<Player> configPlayers(RaceTrack raceTrack) {
        List<Player> players = new ArrayList<>();
        //TODO
        return players;
    }

    @Override
    public void configGame(List<Player> players, RaceTrack raceTrack) {

    }
}
