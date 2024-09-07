/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.controller.file.*;
import it.unicam.cs.vectorrally.api.model.cars.Car;
import it.unicam.cs.vectorrally.api.model.cars.Color;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.BotPlayer;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.iUIRaceController;
import it.unicam.cs.vectorrally.api.view.iUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code GameConfigurator} class implements {@code iGameConfigurator} and is responsible
 * for configuring the game by setting up the race track and players. It interacts with file readers
 * and trackers to load necessary game data and initialize players with appropriate settings.
 */
public class GameConfigurator implements iGameConfigurator {
    private final iUIRaceController controller;
    private final RaceTrackReader raceTrackReader;
    private final BotReader botReader;
    private final TrackFileTracker trackFileTracker;
    private final BotFileTracker botFileTracker;

    /**
     * Constructs a {@code GameConfigurator} with the specified controllers, readers, and trackers.
     *
     * @param controller A {@code UIRaceController} used to interact with the user for game configuration.
     * @param rtr A {@code RaceTrackReader} used to read and create racetracks from files.
     * @param br A {@code BotReader} used to read bot configurations from files.
     * @param trackFileTracker A {@code TrackFileTracker} used to locate track files.
     * @param botFileTracker A {@code BotFileTracker} used to locate bot files.
     */
    public GameConfigurator(iUIRaceController controller, RaceTrackReader rtr, BotReader br, TrackFileTracker trackFileTracker, BotFileTracker botFileTracker) {
        if (controller == null || rtr == null || br == null || trackFileTracker == null || botFileTracker == null) {
            throw new NullPointerException("All parameters can't be null.");
        }
        this.controller = controller;
        this.raceTrackReader = rtr;
        this.botReader = br;
        this.trackFileTracker = trackFileTracker;
        this.botFileTracker = botFileTracker;
    }

    @Override
    public RaceTrack configTrack() throws IOException {
        String trackPath = null;
        List<String> trackContent;

        while (trackPath == null) {
            trackPath = trackFileTracker.findFile(controller.chooseTrack());
            if (trackPath != null) {
                trackContent = iFileReader.readFile(trackPath);
                if (trackContent.isEmpty()) {
                    controller.displayInvalidTrackFile();
                    trackPath = null;
                }
            } else {
                iUtils.printlnText("Please choose another number from the indices");
            }
        }
        return raceTrackReader.createTrack(trackPath);
    }

    @Override
    public List<Player> configPlayers(RaceTrack raceTrack) throws IOException {
        if (raceTrack == null) {
            throw new NullPointerException("RaceTrack cannot be null.");
        }
        List<Player> players = new ArrayList<>();
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Color> colors = Arrays.stream(Color.values()).collect(Collectors.toList());
        String botNumberPath = null;
        while (botNumberPath == null) {
            botNumberPath = botFileTracker.findFile(controller.chooseBots());
            if (botNumberPath == null) iUtils.printlnText("Please choose another number from the indices");
        }
        int botPlayersNumber = botReader.botCounter(botNumberPath);
        addBots(botPlayersNumber, players, startingPositions, colors);
        return players;
    }

    /**
     * Adds bot players to the game based on the number specified and available starting positions.
     *
     * @param botPlayersNumber The number of bot players to add.
     * @param playersList The list to which the bot players will be added.
     * @param startingPositions A list of available starting positions on the race track.
     * @param colors A list of colors available for the bot cars.
     */
    private void addBots(int botPlayersNumber, List<Player> playersList, List<Position> startingPositions, List<Color> colors) {
        if (botPlayersNumber > startingPositions.size()) {
            botPlayersNumber = startingPositions.size();
        }
        for (int i = 0; i < botPlayersNumber; i++) {
            Color botColor = colors.get(i);
            addPlayer(playersList, startingPositions.get(i), botColor);
        }
    }

    /**
     * Adds a single bot player to the specified list with the given starting position and color.
     *
     * @param playersList The list to which the player will be added.
     * @param position The starting position of the player.
     * @param playerColor The color of the player's car.
     */
    private void addPlayer(List<Player> playersList, Position position, Color playerColor) {
        if (playersList == null || position == null || playerColor == null) {
            throw new NullPointerException("Players list, position, and color cannot be null.");
        }
        Car car = new Car(playerColor);
        Player p = new BotPlayer(car);
        p.setPosition(position);
        playersList.add(p);
    }
}
