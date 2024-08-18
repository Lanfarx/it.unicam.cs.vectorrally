package it.unicam.cs.vectorrally.api.controller.file;

import java.util.List;

public interface iFileTracker {

    /**
     * Finds the generic file that ends with that number
     *
     * @param number the number at the end of the file name
     * @return the file that ends with that number
     */
    String findFile(int number);


}
