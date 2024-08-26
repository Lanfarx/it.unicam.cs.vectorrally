/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import it.unicam.cs.vectorrally.api.controller.GameConfigurator;
import it.unicam.cs.vectorrally.api.controller.file.*;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.UIRaceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GameConfiguratorTest {

    private UIRaceController mockController;
    private RaceTrackReader mockRaceTrackReader;
    private BotReader mockBotReader;
    private TrackFileTracker mockTrackFileTracker;
    private BotFileTracker mockBotFileTracker;
    private GameConfigurator gameConfigurator;

    @BeforeEach
    void setUp() {
        mockController = mock(UIRaceController.class);
        mockRaceTrackReader = mock(RaceTrackReader.class);
        mockBotReader = mock(BotReader.class);
        mockTrackFileTracker = mock(TrackFileTracker.class);
        mockBotFileTracker = mock(BotFileTracker.class);
        gameConfigurator = new GameConfigurator(mockController, mockRaceTrackReader, mockBotReader, mockTrackFileTracker, mockBotFileTracker);
    }

    @Test
    void testConfigTrackWithValidFile() throws IOException {
        File testFile = File.createTempFile("track1000", ".txt");
        testFile.deleteOnExit();
        try (PrintWriter out = new PrintWriter(testFile)) {
            out.println(
                    "|||||||||||||||||||||\n" +
                    "|||||||_____|||||||||\n" +
                    "|...................|\n" +
                    "|...................|\n" +
                    "|.....|.......|.....|\n" +
                    "|..|......|......|..|\n" +
                    "|...................|\n" +
                    "|.....|.......|.....|\n" +
                    "|...................|\n" +
                    "|..|.............|..|\n" +
                    "|...................|\n" +
                    "||||||||-----||||||||\n" +
                    "|||||||||||||||||||||");
        }
        String trackPath = testFile.getAbsolutePath();
        int trackNumber = 1000;
        RaceTrack raceTrack = mockRaceTrack();

        when(mockController.chooseTrack()).thenReturn(trackNumber);
        when(mockTrackFileTracker.findFile(trackNumber)).thenReturn(trackPath);
        when(mockRaceTrackReader.createTrack(trackPath)).thenReturn(raceTrack);

        RaceTrack configuredTrack = gameConfigurator.configTrack();
        assertNotNull(configuredTrack);
        assertEquals(raceTrack, configuredTrack);
    }

    private RaceTrack mockRaceTrack() {
        RaceTrack raceTrack = mock(RaceTrack.class);
        when(raceTrack.getSymbolsPosition(TrackSymbol.START)).thenReturn( Arrays.asList
                (new Position(0, 7), new Position(0, 8), new Position(0, 9), new Position(0, 10), new Position(0, 11)));
        return raceTrack;
    }

    @Test
    void testConfigPlayers() throws IOException {
        RaceTrack raceTrack = mockRaceTrack();
        List<Position> startingPositions = Arrays.asList(new Position(0, 0), new Position(1, 1));
        String botFilePath = "bot2.txt";
        int botFileNumber = 2;

        when(mockController.chooseBots()).thenReturn(botFileNumber);
        when(mockBotFileTracker.findFile(botFileNumber)).thenReturn(botFilePath);
        when(mockBotReader.botCounter(botFilePath)).thenReturn(3);
        when(raceTrack.getSymbolsPosition(TrackSymbol.START)).thenReturn(startingPositions);

        List<Player> result = gameConfigurator.configPlayers(raceTrack);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getPosition().equals(new Position(0, 0))));
        assertTrue(result.stream().anyMatch(p -> p.getPosition().equals(new Position(1, 1))));
    }
}
