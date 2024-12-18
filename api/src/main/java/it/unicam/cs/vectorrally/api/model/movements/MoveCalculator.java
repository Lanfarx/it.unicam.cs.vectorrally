/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.movements;

import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MoveCalculator} class implements {@code iMoveCalculator} and provides functionality
 * to calculate and validate moves for players in the game. It checks whether moves are valid based
 * on the track boundaries, track symbols, and collisions with other players.
 */
public class MoveCalculator implements iMoveCalculator {

    /**
     * Calculates a list of possible vectors based on the current acceleration vector.
     *
     * @param acceleration The current acceleration vector.
     * @return A list of possible vectors resulting from different movements.
     */
    private List<Vector> availableVectors(Vector acceleration) {
        List<Vector> vectors = new ArrayList<>();
        int[] Ax = {0, 0, 0, -1, -1, -1, 1, 1, 1};
        int[] Ay = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < 9; i++) {
            vectors.add(new Vector(acceleration.getAx() + Ax[i], acceleration.getAy() + Ay[i]));
        }
        return vectors;
    }

    /**
     * Checks if a move is available based on track boundaries, collisions with track symbols,
     * and collisions with other players.
     *
     * @param move The move to validate.
     * @param raceTrack The racetrack where the move is performed.
     * @param players The list of players currently in the game.
     * @return {@code true} if the move is valid, {@code false} otherwise.
     */
    private boolean isMoveAvailable(Move move, RaceTrack raceTrack, List<Player> players) {
        return  moveIsInTrack(move, raceTrack) &&
                moveNotInstantFinish(move, raceTrack) &&
                playerNotCollidesSymbol(move, raceTrack, TrackSymbol.BORDER) &&
                playerNotCollidesWhileMoving(move, players) &&
                playerNotCollidesPlayer(move, players);
    }

    /**
     * Checks if the move is within the borders of the track.
     *
     * @param move The move to validate.
     * @param raceTrack The racetrack to check against.
     * @return {@code true} if the move is within the track borders, {@code false} otherwise.
     */
    private boolean moveIsInTrack(Move move, RaceTrack raceTrack) {
        Position newPosition = move.getNewPosition();
        return raceTrack.isInTrack(newPosition);
    }

    /**
     * Calculates the path of positions covered during the move from the starting position to the new position.
     *
     * @param move The move for which the path is to be calculated.
     * @return A list of positions representing the path covered by the move.
     */
    private List<Position> getMovingPath(Move move) {
        List<Position> positions = new ArrayList<>();
        Position oldPosition = move.getStartingPosition();
        Position newPosition = move.getNewPosition();
        int AxDiff = newPosition.getX() - oldPosition.getX();
        int AyDiff = newPosition.getY() - oldPosition.getY();
        int steps = Math.max(Math.abs(AxDiff), Math.abs(AyDiff));

        if(steps == 0) positions.add(move.getStartingPosition());
        else for (int i = 1; i <= steps; i++) {
            int xStep = oldPosition.getX() + (i * (AxDiff)) / steps;
            int yStep = oldPosition.getY() + (i * (AyDiff)) / steps;
            positions.add(new Position(xStep, yStep));
        }
        return positions;
    }

    /**
     * Checks if the move collides with any player currently in the game.
     *
     * @param move The move to validate.
     * @param players The list of players to check against.
     * @return {@code true} if the move does not collide with any player, {@code false} otherwise.
     */
    private boolean playerNotCollidesWhileMoving(Move move, List<Player> players) {
        List<Position> movingPositions = getMovingPath(move);

        for (Position position : movingPositions) {
            for (Player player : players) {
                if (player.getPosition().equals(position) &&
                        !(move.getStartingPosition().equals(player.getPosition()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the move collides with any track symbols of the specified type.
     *
     * @param move The move to validate.
     * @param raceTrack The racetrack to check against.
     * @param symbol The type of track symbol to check for collisions.
     * @return {@code true} if the move does not collide with the specified track symbol, {@code false} otherwise.
     */
    private boolean playerNotCollidesSymbol(Move move, RaceTrack raceTrack, TrackSymbol symbol) {
        List<Position> positions = getMovingPath(move);
        List<Position> symbolPositions = raceTrack.getSymbolsPosition(symbol);

        for (Position position : positions) {
            if (symbolPositions.contains(position) || raceTrack.getSymbolAtPosition(move.getNewPosition()) == symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the move collides with any other players' positions.
     *
     * @param move The move to validate.
     * @param players The list of players to check against.
     * @return {@code true} if the move does not collide with any player's position, {@code false} otherwise.
     */
    private boolean playerNotCollidesPlayer(Move move, List<Player> players) {
        Position newPosition = move.getNewPosition();
        for (Player player : players) {
            if (player.getPosition().equals(newPosition)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether the given move will result in an immediate finish
     *
     * @param move The move to check, including the starting and new positions.
     * @param raceTrack The racetrack on which the move is performed, used to retrieve start and end positions.
     * @return {@code true} if the move does not result in an immediate finish, {@code false} if it does.
     */
    private boolean moveNotInstantFinish(Move move, RaceTrack raceTrack) {
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Position> endingPositions = raceTrack.getSymbolsPosition(TrackSymbol.END);
        if (startingPositions.contains(move.getStartingPosition())) {
            return !endingPositions.contains(move.getNewPosition());
        }
        return true;
    }

    @Override
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
