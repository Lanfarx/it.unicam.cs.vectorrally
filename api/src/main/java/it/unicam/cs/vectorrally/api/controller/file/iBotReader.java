package it.unicam.cs.vectorrally.api.controller.file;

import java.io.IOException;

public interface iBotReader {

    /**
     * Counts the number of bots by reading the file
     *
     * @param filepath the given file that represents the bots
     * @return the number of bots
     * @throws IOException if an IO error happens
     */
    int botCounter(String filepath) throws IOException;
}
