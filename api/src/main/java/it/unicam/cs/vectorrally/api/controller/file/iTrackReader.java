/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller.file;

import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;

import java.io.IOException;

/**
 * The {@code iTrackReader} interface defines a contract for classes that
 * create a {@code RaceTrack} object by reading a file.
 * It includes a method for generating a {@code RaceTrack} based on the data
 * read from a specified file.
 */
public interface iTrackReader {

    /**
     * Creates a {@code RaceTrack} object by reading the contents of the specified file.
     *
     * @param filepath A {@code String} representing the path to the file that contains the data for the {@code RaceTrack}.
     * @return A {@code RaceTrack} object created from the data in the specified file.
     * @throws IOException If an I/O error occurs
     */
    RaceTrack createTrack(String filepath) throws IOException;
}