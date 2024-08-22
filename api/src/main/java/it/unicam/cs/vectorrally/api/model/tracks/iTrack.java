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

import java.util.List;

/**
 * The {@code iTrack} interface defines a contract for classes that represent a race track.
 * This interface includes methods for obtaining the dimensions of the track, getting the positions
 * of specific symbols on the track, and checking if a position is within track boundaries.
 */
public interface iTrack {

    /**
     * Retrieves the length of the track.
     *
     * @return An {@code int} representing the length of the track.
     */
    int getLength();

    /**
     * Retrieves the width of the track.
     *
     * @return An {@code int} representing the width of the track.
     */
    int getWidth();

    /**
     * Retrieves the positions of a specified symbol on the track.
     *
     * @param symbol A {@code TrackSymbol} representing the symbol to search for.
     * @return A {@code List<Position>} containing the positions of the corresponding symbol on the track.
     */
    List<Position> getSymbolsPosition(TrackSymbol symbol);

    /**
     * Retrieves the symbol located at the specified position on the track.
     *
     * @param position A {@code Position} representing the location on the track.
     * @return A {@code TrackSymbol} representing the symbol at the specified position.
     * @throws IllegalArgumentException if the specified position is out of the track's boundaries.
     */
    TrackSymbol getSymbolAtPosition(Position position);

    /**
     * Checks whether a given position is within the track's borders.
     *
     * @param position A {@code Position} representing the location to be checked.
     * @return {@code true} if the position is within the track's borders, otherwise {@code false}.
     */
    boolean isInTrack(Position position);
}
