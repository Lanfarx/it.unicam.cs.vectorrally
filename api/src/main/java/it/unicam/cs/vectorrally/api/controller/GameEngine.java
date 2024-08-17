package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.view.UIController;

import java.util.List;

public class GameEngine implements iGameEngine{
    private List<Player> players;
    private RaceTrack raceTrack;
    private final UIController controller;


    public GameEngine(UIController controller){
        this.controller = controller;
        BotReader botReader = new BotReader();
        RaceTrackReader raceTrackReader = new RaceTrackReader();
    }

    @Override
    public void startApp() throws Exception {

    }
}
