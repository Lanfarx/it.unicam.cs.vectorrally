package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.players.Player;

import java.util.List;
import java.util.Random;

public class BotManager {

    public Move nextMove(Player player, List<Move> availableMoves){
        Random rand = new Random();
        int randomMoveIndex = rand.nextInt(availableMoves.size());
        return availableMoves.get(randomMoveIndex);
    }
}
