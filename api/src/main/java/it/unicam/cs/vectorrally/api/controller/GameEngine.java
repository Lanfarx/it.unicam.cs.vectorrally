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
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

/**
 * The {@code GameEngine} class implements the {@code iGameEngine} interface and is responsible
 * for managing the overall game flow, including initializing game components, configuring the
 * game, and handling game logic.
 */
public class GameEngine implements iGameEngine {
    private final UIRaceController controller;
    private final GameConfigurator configurator;

    /**
     * Creates a {@code GameEngine} instance with the specified {@code UIRaceController}.
     * Initializes the game configuration components and prepares the game engine for operation.
     *
     * @param controller a {@code UIRaceController} used for interacting with the user interface
     */
    public GameEngine(UIRaceController controller) {
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
        GameController gameController = new GameController(controller, new MoveCalculator());
        RaceTrack configuredRaceTrack = configurator.configTrack();
        gameController.startGame(configuredRaceTrack, this.configurator.configPlayers(configuredRaceTrack));
        gameController.run();
    }
}
