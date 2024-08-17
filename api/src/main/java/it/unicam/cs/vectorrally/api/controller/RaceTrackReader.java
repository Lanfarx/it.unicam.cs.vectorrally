package it.unicam.cs.vectorrally.api.controller;

import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.tracks.TrackSymbol;

import java.io.IOException;
import java.util.List;

public class RaceTrackReader implements iTrackReader {

    @Override
    public RaceTrack createTrack(String trackName) throws IOException {
        List<String> trackLines = iFileReader.readFile(trackName);
        TrackSymbol[][] symbolMatrix = new TrackSymbol[trackLines.size()][trackLines.get(0).length()];
        for (int i = 0; i < trackLines.size(); i++) {
            for (int j = 0; j < trackLines.get(i).length(); j++) {
                symbolMatrix[i][j] = TrackSymbol.realTrackSymbol(trackLines.get(i).charAt(j));
            }
        } RaceTrack raceTrack = new RaceTrack(symbolMatrix);
        raceTrackValidator(raceTrack);
        return raceTrack;
    }

    private void raceTrackValidator(RaceTrack raceTrack) {
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Position> endingPositions = raceTrack.getSymbolsPosition(TrackSymbol.END);
        if(startingPositions.isEmpty() || endingPositions.isEmpty()) throw new IllegalArgumentException("Track is not valid, cannot find the starting or ending lines");
    }
}
