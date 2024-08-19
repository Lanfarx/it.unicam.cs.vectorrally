package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.players.BotPlayer;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.UIRaceController;
import java.util.List;

public class GameController implements iGameController {
    private RaceTrack raceTrack;
    private List<Player> players;
    private final UIRaceController uiRaceController;
    private MoveCalculator moveCalculator;
    private boolean running;

    public GameController(UIRaceController uiRaceController, MoveCalculator moveCalculator) {
        this.uiRaceController = uiRaceController;
        this.moveCalculator = moveCalculator;
    }

    @Override
    public void startGame(List<Player> players, RaceTrack raceTrack) throws Exception {
        this.raceTrack = raceTrack;
        this.players = players;
        running = true;
        uiRaceController.displayStart();
    }

    public void run() throws Exception {
        Thread.sleep(1000);
        while (running) {
            for (Player player : players) {
                playerTurn(player);
                if (someoneWon()) endGame();
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void playerTurn(Player player) throws Exception {
        uiRaceController.displayPlayerTurn(player);
        uiRaceController.displayTrack(raceTrack, players);
        List<Move> availableMoves = moveCalculator.availableMoves(player, raceTrack, players);
        if(availableMoves.isEmpty()) playerElimination(player);
        if(player instanceof BotPlayer bot) {
            BotManager botManager = new BotManager();
            Move move = botManager.nextMove(bot, availableMoves);
            moveDeploy(player, move);
        } else {
            //TODO INTERACTIVE PLAYER
        }
    }

    @Override
    public void playerElimination(Player player) throws Exception {
        uiRaceController.displayPlayerElimination(player);
        this.players.remove(player);
        if (players.isEmpty()) {
            running = false;
            uiRaceController.displayEnd();
        }
    }

    private void moveDeploy(Player player, Move move) throws Exception {
        player.setPosition(move.getNewPosition());
        player.setPlayerAcceleration(move.getAcceleration());
        uiRaceController.displayPlayerMove(player, move);

    }

    public boolean someoneWon() throws Exception {
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

    public void endGame(){
        running = false;
        uiRaceController.displayEnd();
    }
}