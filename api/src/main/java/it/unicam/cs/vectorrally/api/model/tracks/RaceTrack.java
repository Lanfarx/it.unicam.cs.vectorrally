/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.tracks;

import it.unicam.cs.vectorrally.api.model.movements.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code RaceTrack} class implements the {@code iTrack} interface and represents a racing track
 * using a matrix of {@code TrackSymbol} values. This class provides functionality to access track dimensions
 * and retrieve information about specific positions on the track.
 */
public class RaceTrack implements iTrack {

    private final int length;
    private final int width;
    private final TrackSymbol[][] RaceTrack;

    /**
     * Constructs a {@code RaceTrack} instance based on the given matrix of {@code TrackSymbol} values.
     * <p>
     * The matrix represents the track where each element corresponds to a symbol indicating different track
     * features such as start, end, borders, or circuit path.
     * </p>
     *
     * @param raceTrack A 2D array of {@code TrackSymbol} representing the track. This matrix must not be null
     *                  or empty. Each element of the matrix specifies a particular symbol on the track.
     * @throws IllegalArgumentException if the provided matrix is {@code null}, or if it is empty (i.e.,
     *                                   if the matrix or its first row has a length of zero).
     */
    public RaceTrack(TrackSymbol[][] raceTrack) {
        if (raceTrack == null || raceTrack.length == 0 || raceTrack[0].length == 0) {
            throw new IllegalArgumentException("Track is not valid");
        }
        this.RaceTrack = raceTrack;
        this.length = RaceTrack[0].length;
        this.width = RaceTrack.length;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public List<Position> getSymbolsPosition(TrackSymbol symbol) {
        List<Position> currentSymbolsPositions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (this.RaceTrack[i][j] == symbol) currentSymbolsPositions.add(new Position(i, j));
            }
        }
        return currentSymbolsPositions;
    }

    @Override
    public TrackSymbol getSymbolAtPosition(Position position) {
        if(!isInTrack(position)) throw new IllegalArgumentException("Position is not in track");
        return this.RaceTrack[position.getX()][position.getY()];
    }

    @Override
    public boolean isInTrack(Position position) {
        return (position.getX() >= 0 && position.getX() < this.width && position.getY() >= 0 && position.getY() < this.length);
    }
}
