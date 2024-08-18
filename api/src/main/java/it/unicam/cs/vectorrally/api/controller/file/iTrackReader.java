package it.unicam.cs.vectorrally.api.controller.file;

import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.io.IOException;

public interface iTrackReader {

    /**
     * Creates the RaceTrack by reading the file
     *
     * @param filepath the given file that represents the RaceTrack
     * @return the RaceTrack
     * @throws IOException if an IO error happens
     */
    RaceTrack createTrack(String filepath) throws IOException;
}
