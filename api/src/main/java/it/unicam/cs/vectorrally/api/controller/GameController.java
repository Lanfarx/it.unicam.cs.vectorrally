package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

import java.util.ArrayList;
import java.util.List;

public class GameController implements iGameController {
    private RaceTrack raceTrack;
    private List<Player> players;
    private UIRaceController uiRaceController;
    private boolean running;

    public GameController(UIRaceController uiRaceController) {
        this.uiRaceController = uiRaceController;
    }

    @Override
    public void startGame(List<Player> players, RaceTrack raceTrack) throws Exception {
        this.raceTrack = raceTrack;
        this.players = players;
        running = true;
        uiRaceController.displayStart();
    }

    public void run() throws Exception {
        while (running) {
            someoneWon();
        }
    }

    @Override
    public void playerTurn(Player player) throws Exception {
        uiRaceController.displayPlayerTurn(player);
        //TODO CONTROLLARE MOSSE
    }


    @Override
    public void playerElimination(Player player) throws Exception {
        //TODO
    }

    public boolean someoneWon() throws Exception {
        for (Player player : players) {
            if (raceTrack.isInTrack(player.getPosition())) {
                List<Position> endings = raceTrack.getSymbolsPosition(TrackSymbol.END);
                if (endings.contains(player.getPosition())) {
                    running = false;
                    return true;
                }
            }
        }
        return false;
    }
}