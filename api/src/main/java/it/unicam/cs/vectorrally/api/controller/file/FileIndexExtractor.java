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
 * The {@code FileIndexExtractor} class provides functionality to extract numeric indices from filenames
 * in a specific directory with a given prefix.
 */
public class FileIndexExtractor {

    /**
     * Retrieves a list of numeric indices from files with the specific prefix in the given directory.
     *
     * @param filePrefix the prefix used to identify files
     * @param directoryPath the path to the directory containing the files
     * @return a {@code List<Integer>} of indices extracted from file names
     */
    public static List<Integer> getFileIndices(String filePrefix, String directoryPath) {
        File directory = new File(directoryPath);
        List<Integer> indices = new ArrayList<>();

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a directory.");
        }

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
        }

        return indices;
    }
}
