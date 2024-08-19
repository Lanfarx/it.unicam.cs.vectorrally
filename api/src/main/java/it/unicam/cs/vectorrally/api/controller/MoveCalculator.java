package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.movements.Vector;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;

import java.util.ArrayList;
import java.util.List;

public class MoveCalculator implements iMoveCalculator {

    private List<Vector> availableVectors(Vector acceleration) {
        List<Vector> vectors = new ArrayList<>();
        int[] Ax = {0, 0, 0, -1, -1, -1, 1, 1, 1};
        int[] Ay = {0, -1, 1, -1, 0, 1, -1, 0, 1};
        for (int i = 0; i < 9; i++)
            vectors.add(new Vector(acceleration.getAx() + Ax[i], acceleration.getAy() + Ay[i]));
        return vectors;
    }

    private boolean isMoveAvailable(Move move, RaceTrack raceTrack, List<Player> players) {
        if (moveIsInTrack(move, raceTrack))
            if(playerNotCollidesSymbol(move, raceTrack, TrackSymbol.BORDER))
                if (playerNotCollidesMoving(move, players))
                    return playerNotCollidesPlayer(move, players);
        return false;
    }

    private boolean moveIsInTrack(Move move, RaceTrack raceTrack) {
        Position newPosition = move.getNewPosition();
        return raceTrack.isInTrack(newPosition);
    }

    private List<Position> getMovingPath(Move move) {
        List<Position> positions = new ArrayList<>();
        Position oldPosition = move.getStartingPosition();
        Position newPosition = move.getNewPosition();
        int AxDiff = Math.abs(newPosition.getX() - oldPosition.getX());
        int AyDiff = Math.abs(newPosition.getY() - oldPosition.getY());
        int steps = Math.max(AxDiff, AyDiff);
        for (int i = 0; i <= steps; i++) {
            int xStep = oldPosition.getX() + (i * (AxDiff)) / steps;
            int yStep = oldPosition.getY() + (i * (AyDiff)) / steps;
            positions.add(new Position(xStep, yStep));
        } return positions;
    }

    private boolean playerNotCollidesMoving(Move move, List<Player> players) {
        List<Position> movingPositions = getMovingPath(move);

        for (Position position : movingPositions)
            for (Player player : players)
                if (player.getPosition().equals(move.getStartingPosition()) && player.getPosition().equals(position))
                    return false;
        return true;
    }

    private boolean playerNotCollidesSymbol(Move move, RaceTrack raceTrack, TrackSymbol symbol) {
        List<Position> positions = getMovingPath(move);
        List<Position> symbolPositions = raceTrack.getSymbolsPosition(symbol);

        for (Position position : positions)
            if (!symbolPositions.contains(position))
                return false;
        return true;
    }

    private boolean playerNotCollidesPlayer(Move move, List<Player> players) {
        Position newPosition = move.getNewPosition();
        for (Player player : players)
            if (!player.getPosition().equals(newPosition))
                return false;
        return true;
    }

    public List<Move> availableMoves(Player player, RaceTrack raceTrack, List<Player> players) {
        List<Move> moves = new ArrayList<>();
        List<Vector> availableVectors = availableVectors(player.getPlayerAcceleration());
        for (Vector vector : availableVectors) {
            Move availableMove = new Move(new Vector(vector.getAx(), vector.getAy()), player.getPosition());
            if (isMoveAvailable(availableMove, raceTrack, players))
                moves.add(availableMove);
        }
        return moves;
    }
}
