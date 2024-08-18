package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.cars.Car;
import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.controller.file.BotFileTracker;
import it.unicam.cs.vectorrally.api.controller.file.BotReader;
import it.unicam.cs.vectorrally.api.controller.file.RaceTrackReader;
import it.unicam.cs.vectorrally.api.controller.file.TrackFileTracker;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.players.BotPlayer;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameConfigurator implements iGameConfigurator {
    private final UIRaceController controller;
    private final RaceTrackReader raceTrackReader;
    private final BotReader botReader;
    private final TrackFileTracker trackFileTracker;
    private final BotFileTracker botFileTracker;


    public GameConfigurator(UIRaceController controller, RaceTrackReader rtr, BotReader br, TrackFileTracker trackFileTracker, BotFileTracker botFileTracker) {
        this.controller = controller;
        this.raceTrackReader = rtr;
        this.botReader = br;
        this.trackFileTracker = trackFileTracker;
        this.botFileTracker = botFileTracker;
    }

    @Override
    public RaceTrack configTrack() throws IOException {
        String track = trackFileTracker.findFile(controller.chooseTrack());
        return raceTrackReader.createTrack(track);
    }

    @Override
    public List<Player> configPlayers(RaceTrack raceTrack) throws IOException {
        List<Player> players = new ArrayList<>();
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Color> colors = new ArrayList<>(List.of(Color.values()));
        int botPlayersNumber = botReader.botCounter(botFileTracker.findFile(controller.chooseBots()));
        addBots(botPlayersNumber, players, startingPositions, colors);
        return players;
    }

    public void addBots(int botPlayersNumber, List<Player> playersList, List<Position> startingPositions, List<Color> colors) {
        if(botPlayersNumber > startingPositions.size()) botPlayersNumber = startingPositions.size();
        for(int i = 0; i < botPlayersNumber; i++) {
            Color botColor = colors.get(i);
            addPlayer(playersList, startingPositions.get(i), botColor);
        }
    }

    public void addPlayer(List<Player> playersList, Position position, Color playerColor) {
        Car car = new Car(playerColor);
        Player p = new BotPlayer(car);
        p.setPosition(position);
        playersList.add(p);
    }
}
