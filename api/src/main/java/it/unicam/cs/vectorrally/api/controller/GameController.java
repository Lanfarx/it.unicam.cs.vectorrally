/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.MoveCalculator;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.BotPlayer;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code GameController} class implements {@code iGameController} and manages the
 * overall game flow, including game start, player turns, eliminations, and checking for a winner.
 * It interacts with the user interface and move calculator to control the game state.
 */
public class GameController implements iGameController {
    private RaceTrack raceTrack;
    private List<Player> players;
    private final UIRaceController uiRaceController;
    private final MoveCalculator moveCalculator;

    private boolean running;

    /**
     * Constructs a {@code GameController} with the specified user interface controller and move calculator.
     *
     * @param uiRaceController An {@code UIRaceController} used to interact with the user and display game information.
     * @param moveCalculator A {@code MoveCalculator} used to determine available moves for players.
     */
    public GameController(UIRaceController uiRaceController, MoveCalculator moveCalculator) {
        if (uiRaceController == null || moveCalculator == null) {
            throw new NullPointerException("UIRaceController and MoveCalculator cannot be null.");
        }
        this.uiRaceController = uiRaceController;
        this.moveCalculator = moveCalculator;
        this.running = false;
    }

    @Override
    public void startGame(RaceTrack raceTrack, List<Player> players) {
        this.raceTrack = raceTrack;
        this.players = players;
        running = true;
        uiRaceController.displayStart();
        uiRaceController.displayMessage("STARTING TRACK:");
        uiRaceController.displayTrack(this.raceTrack, this.players);
    }

    @Override
    public void run() throws Exception {
        Thread.sleep(1000);
        while (running) {
            for (Player player : new ArrayList<>(players)) {
                playerTurn(player);
                if (someoneWon()) {
                    endGame();
                    return;
                }
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void playerTurn(Player player) {
        uiRaceController.displayPlayerTurn(player);
        List<Move> availableMoves = moveCalculator.availableMoves(player, raceTrack, players);
        if (availableMoves.isEmpty()) playerElimination(player);
        else if (player instanceof BotPlayer) {
            BasicBotManager botManager = new BasicBotManager();
            Move move = botManager.nextMove(availableMoves);
            moveDeploy(player, move);
        } else {
            //TODO INTERACTIVE PLAYER
        }
    }

    @Override
    public void playerElimination(Player player) {
        uiRaceController.displayPlayerElimination(player);
        this.players.remove(player);
        if (players.isEmpty()) {
            running = false;
            uiRaceController.displayMessage("EVERYONE HAS BEEN ELIMINATED");
            uiRaceController.displayEnd();
        }
    }

    /**
     * Updates the position and acceleration of the given player based on the specified move.
     *
     * @param player A {@code Player} whose position and acceleration are to be updated.
     * @param move A {@code Move} containing the new position and acceleration to be applied.
     * @throws NullPointerException if the {@code player} or {@code move} is {@code null}.
     */
    private void moveDeploy(Player player, Move move) {
        if (player == null || move == null) {
            throw new NullPointerException("Player and Move cannot be null.");
        }
        player.setPosition(move.getNewPosition());
        player.setPlayerAcceleration(move.getAcceleration());
        uiRaceController.displayPlayerMove(player, move);
        uiRaceController.displayTrack(this.raceTrack, this.players);
    }

    /**
     * Checks if there is a winner in the game.
     *
     * @return {@code true} if a player has won the game; {@code false} otherwise.
     */
    private boolean someoneWon(){
        for (Player player : players) {
            if (raceTrack.isInTrack(player.getPosition())) {
                List<Position> endings = raceTrack.getSymbolsPosition(TrackSymbol.END);
                if (endings.contains(player.getPosition())) {
                    running = false;
                    uiRaceController.displayVictory(player);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void endGame() {
        running = false;
        uiRaceController.displayEnd();
    }

    public boolean isRunning() {
        return running;
    }
}