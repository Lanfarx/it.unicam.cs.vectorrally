package it.unicam.cs.vectorrally.app.controller;

import it.unicam.cs.vectorrally.app.tracks.RaceTrack;

import java.io.IOException;

public interface iTrackReader {

    /**
     * Creates the RaceTrack by reading the file
     *
     * @param trackName the given file that represents the RaceTrack
     * @return the RaceTrack
     * @throws IOException if an IO error happens
     */
    RaceTrack createTrack(String trackName) throws IOException;
}
