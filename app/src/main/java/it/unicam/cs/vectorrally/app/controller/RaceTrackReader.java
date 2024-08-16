package it.unicam.cs.vectorrally.app.controller;

import it.unicam.cs.vectorrally.app.movements.Position;
import it.unicam.cs.vectorrally.app.tracks.RaceTrack;
import it.unicam.cs.vectorrally.app.tracks.TrackSymbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RaceTrackReader implements iTrackReader {

    @Override
    public RaceTrack createTrack(String trackName) throws IOException {
        List<String> trackLines = readTrack(trackName);
        TrackSymbol[][] symbolMatrix = new TrackSymbol[trackLines.size()][trackLines.get(0).length()];
        for (int i = 0; i < trackLines.size(); i++) {
            for (int j = 0; j < trackLines.get(i).length(); j++) {
                symbolMatrix[i][j] = TrackSymbol.realTrackSymbol(trackLines.get(i).charAt(j));
            }
        }
        RaceTrack raceTrack = new RaceTrack(symbolMatrix);
        //check if the raceTrack is valid
        List<Position> startingPositions = raceTrack.getSymbolsPosition(TrackSymbol.START);
        List<Position> endingPositions = raceTrack.getSymbolsPosition(TrackSymbol.END);
        if(startingPositions.isEmpty() || endingPositions.isEmpty()) throw new IllegalArgumentException("Track is not valid, cannot find the starting or ending lines");
        return raceTrack;
    }

    /**
     * Reads the track from the given file
     *
     * @param trackName the given file containing the track to be read
     * @return a list of strings representing the read track
     * @throws IOException if an IO error happens
     */
    public List<String> readTrack (String trackName) throws IOException {
        List<String> trackLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(trackName));
        String lines;
        while ((lines = br.readLine()) != null) {
            trackLines.add(lines);
        }
        return trackLines;
    }
}
