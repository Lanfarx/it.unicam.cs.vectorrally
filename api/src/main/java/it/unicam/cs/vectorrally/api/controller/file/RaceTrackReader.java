/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller.file;

import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;

import java.io.IOException;
import java.util.List;

/**
 * The {@code RaceTrackReader} class implements {@code iTrackReader} and provides functionality to create a {@code RaceTrack}
 * from a file. It reads the track file, converts the content into a matrix of {@code TrackSymbol} values, and validates the track.
 */
public class RaceTrackReader implements iTrackReader {

    @Override
    public RaceTrack createTrack(String trackName) throws IOException {
        List<String> trackLines = iFileReader.readFile(trackName);
        TrackSymbol[][] symbolMatrix = new TrackSymbol[trackLines.size()][trackLines.get(0).length()];
        for (int i = 0; i < trackLines.size(); i++) {
            for (int j = 0; j < trackLines.get(i).length(); j++) {
                symbolMatrix[i][j] = TrackSymbol.realTrackSymbol(trackLines.get(i).charAt(j));
            }
        }
        RaceTrack raceTrack = new RaceTrack(symbolMatrix);
        raceTrackValidator(raceTrack);
        return raceTrack;
    }

    /**
     * Validates the created {@code RaceTrack} to ensure that it contains at least one start and one end position.
     *
     * @param raceTrack the {@code RaceTrack} to be validated
     * @throws IllegalArgumentException if the track does not contain valid start or end positions
     */
    private void raceTrackValidator(RaceTrack raceTrack) {
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Position> endingPositions = raceTrack.getSymbolsPosition(TrackSymbol.END);
        if (startingPositions.isEmpty() || endingPositions.isEmpty()) {
            throw new IllegalArgumentException("Track is not valid, cannot find the starting or ending lines");
        }
    }
}

