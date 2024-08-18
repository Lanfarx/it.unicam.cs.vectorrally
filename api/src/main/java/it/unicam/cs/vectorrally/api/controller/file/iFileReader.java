package it.unicam.cs.vectorrally.api.controller.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface iFileReader {

    /**
     * Reads the strings from the given file
     *
     * @param file the given file containing the track to be read
     * @return a list of strings representing the read track
     * @throws IOException if an IO error happens
     */
    static List<String> readFile(String file) throws IOException{
        List<String> stringLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            stringLines.add(line);
        }
        return stringLines;
    }
}
