/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code FileIndexExtractor} class provides utility methods to extract numerical indices from file names
 * in a specified directory. It searches for files that match a given prefix and follow a specific naming pattern
 * and returns the list of extracted indices.
 */
public class FileIndexExtractor {

    /**
     * Extracts numerical indices from files in the specified directory that match the given prefix and pattern.
     * The pattern expects files to be named in the format: "prefix<index>.txt", where <index> is a numerical value.
     *
     * @param filePrefix    The prefix that file names should start with ("track" or "bot").
     * @param directoryPath The path to the directory where the files are located.
     * @return A list of extracted numerical indices from the matching files.
     * @throws IllegalArgumentException if the provided path is not a valid directory.
     */
    public static List<Integer> getFileIndices(String filePrefix, String directoryPath) {
        File directory = new File(directoryPath);
        List<Integer> indices = new ArrayList<>();

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a directory.");
        }
        return getIndices(filePrefix, directory, indices);
    }

    /**
     * Helper method that performs the actual extraction of indices from file names in the directory.
     * This method uses a regular expression to match file names and extract the numeric index.
     *
     * @param filePrefix The prefix that file names should start with.
     * @param directory  The directory where the files are located.
     * @param indices    The list to which extracted indices will be added.
     * @return The list of extracted numerical indices from the matching files.
     */
    private static List<Integer> getIndices(String filePrefix, File directory, List<Integer> indices) {
        File[] files = directory.listFiles((dir, name) -> name.startsWith(filePrefix) && name.matches(".*\\d+\\.txt$"));
        if (files != null) {
            Pattern pattern = Pattern.compile(filePrefix + "(\\d+)\\.txt$");
            for (File file : files) {
                String fileName = file.getName();
                Matcher matcher = pattern.matcher(fileName);
                if (matcher.find()) {
                    try {
                        int index = Integer.parseInt(matcher.group(1));
                        indices.add(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Failed to parse index from file name: " + fileName);
                    }
                }
            }
        } return indices;
    }
}
