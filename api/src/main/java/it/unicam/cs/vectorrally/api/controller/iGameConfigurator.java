/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.io.IOException;
import java.util.List;

/**
 * The {@code iGameConfigurator} interface defines methods for configuring a racing game.
 * It includes functionality for setting up the race track and configuring the players,
 * including both bot and interactive players.
 */
public interface iGameConfigurator {

    /**
     * Configures and returns the race track for the game.
     *
     * @return a {@code RaceTrack} object representing the configured track for the game
     * @throws IOException if an I/O error occurs while reading track configuration
     */
    RaceTrack configTrack() throws IOException;

    /**
     * Configures and returns a list of players for the game.
     * This includes both bot players and interactive players.
     *
     * @param raceTrack the {@code RaceTrack} on which the players will compete
     * @return a {@code List<Player>} containing all the configured players for the game
     * @throws IOException if an I/O error occurs while reading player configuration
     */
    List<Player> configPlayers(RaceTrack raceTrack) throws IOException;
}
