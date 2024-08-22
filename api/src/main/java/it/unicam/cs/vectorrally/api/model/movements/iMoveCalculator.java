/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.movements;

import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;

import java.util.List;

/**
 * The {@code iMoveCalculator} interface defines a contract for classes that
 * calculate and provide all possible moves a player can make on a race track.
 * It includes a method to determine the available moves based on the current state
 * of the player, the race track, and other players.
 */
public interface iMoveCalculator {

    /**
     * Obtains all the possible moves that the given player can choose based on their
     * current position, the race track, and the positions of all other players.
     *
     * @param player A {@code Player} object representing the player who is moving.
     * @param raceTrack A {@code RaceTrack} object representing the current track.
     * @param players A {@code List<Player>} representing all the players currently on the track.
     * @return A {@code List<Move>} containing all the available moves the player can make.
     */
    List<Move> availableMoves(Player player, RaceTrack raceTrack, List<Player> players);
}