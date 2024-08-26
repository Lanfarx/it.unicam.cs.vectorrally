/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller;

import it.unicam.cs.vectorrally.api.controller.GameController;
import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.MoveCalculator;
import it.unicam.cs.vectorrally.api.model.players.BotPlayer;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.view.UIRaceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private GameController gameController;
    private UIRaceController mockUIRaceController;
    private MoveCalculator mockMoveCalculator;
    private RaceTrack mockRaceTrack;
    private List<Player> mockPlayers;

    @BeforeEach
    void setUp() {
        mockUIRaceController = mock(UIRaceController.class);
        mockMoveCalculator = mock(MoveCalculator.class);
        mockRaceTrack = mock(RaceTrack.class);
        mockPlayers = mock(ArrayList.class);

        gameController = new GameController(mockUIRaceController, mockMoveCalculator);
    }

    @Test
    void testStartGame() {
        gameController.startGame(mockRaceTrack, mockPlayers);
        verify(mockUIRaceController).displayStart();
        verify(mockUIRaceController).displayMessage("STARTING TRACK:");
        verify(mockUIRaceController).displayTrack(mockRaceTrack, mockPlayers);
        assertTrue(gameController.isRunning());
    }

    @Test
    void testPlayerTurn() {
        Player mockPlayer = mock(BotPlayer.class);
        List<Move> mockAvailableMoves = mock(ArrayList.class);
        Move mockMove = mock(Move.class);
        when(mockMoveCalculator.availableMoves(mockPlayer, mockRaceTrack, mockPlayers)).thenReturn(mockAvailableMoves);
        when(mockAvailableMoves.isEmpty()).thenReturn(false);
        when(mockAvailableMoves.get(anyInt())).thenReturn(mockMove);

        gameController.startGame(mockRaceTrack, mockPlayers);
        gameController.playerTurn(mockPlayer);

        verify(mockMoveCalculator).availableMoves(mockPlayer, mockRaceTrack, mockPlayers);
        verify(mockUIRaceController).displayPlayerTurn(mockPlayer);
    }

    @Test
    void testPlayerElimination() {
        Player mockPlayer = mock(Player.class);
        when(mockPlayers.isEmpty()).thenReturn(true);
        gameController.startGame(mockRaceTrack, mockPlayers);
        gameController.playerElimination(mockPlayer);
        verify(mockUIRaceController).displayPlayerElimination(mockPlayer);
        verify(mockUIRaceController).displayMessage("EVERYONE HAS BEEN ELIMINATED");
        verify(mockUIRaceController).displayEnd();
        assertFalse(gameController.isRunning());
    }

    @Test
    void testEndGame() {
        gameController.startGame(mockRaceTrack, mockPlayers);
        gameController.endGame();

        verify(mockUIRaceController).displayEnd();
        assertFalse(gameController.isRunning());
    }

    @Test
    void testRunGame() throws Exception {
        Player mockPlayer = mock(BotPlayer.class);
        List<Move> mockAvailableMoves = mock(ArrayList.class);
        Move mockMove = mock(Move.class);

        when(mockMoveCalculator.availableMoves(mockPlayer, mockRaceTrack, mockPlayers)).thenReturn(mockAvailableMoves);
        when(mockAvailableMoves.isEmpty()).thenReturn(false);
        when(mockAvailableMoves.get(anyInt())).thenReturn(mockMove);
        when(mockPlayers.isEmpty()).thenReturn(false);
        when(mockPlayers.get(0)).thenReturn(mockPlayer);

        gameController.startGame(mockRaceTrack, mockPlayers);

        doAnswer(invocation -> {
            gameController.endGame();
            return null;
        }).when(mockUIRaceController).displayVictory(mockPlayer);

        gameController.startGame(mockRaceTrack, mockPlayers);
        gameController.run();

        verify(mockUIRaceController).displayVictory(mockPlayer);
        assertFalse(gameController.isRunning());
    }
}
