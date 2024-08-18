package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.controller.file.*;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements iGameEngine{
    private List<Player> players;
    private RaceTrack raceTrack;
    private final UIRaceController controller;
    private final GameConfigurator configurator;


    public GameEngine(UIRaceController controller){
        this.controller = controller;
        RaceTrackReader raceTrackReader = new RaceTrackReader();
        BotReader botReader = new BotReader();
        ResourceDirectoryFinder resourceDirectoryFinder = new ResourceDirectoryFinder();
        TrackFileTracker trackFileTracker = new TrackFileTracker(resourceDirectoryFinder);
        BotFileTracker botFileTracker = new BotFileTracker(resourceDirectoryFinder);
        this.configurator = new GameConfigurator(controller, raceTrackReader, botReader, trackFileTracker, botFileTracker);
    }

    @Override
    public void start() throws Exception {
        GameController gameController = new GameController(controller);
        gameController.startGame(this.configurator.configPlayers(this.raceTrack),this.configurator.configTrack());
        gameController.run();

    }

    public void endGame(){
        controller.displayEnd();
    }

}
