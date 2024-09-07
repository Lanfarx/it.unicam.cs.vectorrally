/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static it.unicam.cs.vectorrally.api.controller.file.FileIndexExtractor.getFileIndices;
import static org.junit.jupiter.api.Assertions.*;

class FileIndexExtractorTest {
    private Path testDirectory;

    @BeforeEach
    void setUp() throws IOException {
        testDirectory = Files.createTempDirectory("testDirectory");
    }

    @Test
    void testGetFileIndicesValidFiles() throws IOException {
        Files.createFile(testDirectory.resolve("track1.txt"));
        Files.createFile(testDirectory.resolve("track2.txt"));
        Files.createFile(testDirectory.resolve("track10.txt"));

        List<Integer> indices = getFileIndices("track", testDirectory.toString());

        assertEquals(3, indices.size());
        assertTrue(indices.contains(1));
        assertTrue(indices.contains(2));
        assertTrue(indices.contains(10));
    }

    @Test
    void testGetFileIndicesInvalidFiles() throws IOException {
        Files.createFile(testDirectory.resolve("trackA.txt"));
        Files.createFile(testDirectory.resolve("track.txt"));
        Files.createFile(testDirectory.resolve("track-1.txt"));

        List<Integer> indices = getFileIndices("track", testDirectory.toString());

        assertTrue(indices.isEmpty());
    }

    @Test
    void testGetFileIndicesMixedFiles() throws IOException {
        Files.createFile(testDirectory.resolve("track1.txt"));
        Files.createFile(testDirectory.resolve("track2.txt"));
        Files.createFile(testDirectory.resolve("invalid.txt"));
        Files.createFile(testDirectory.resolve("track-3.txt"));

        List<Integer> indices = getFileIndices("track", testDirectory.toString());

        assertEquals(2, indices.size());
        assertTrue(indices.contains(1));
        assertTrue(indices.contains(2));
    }

    @Test
    void testGetFileIndicesEmptyDirectory() {
        List<Integer> indices = getFileIndices("track", testDirectory.toString());

        assertTrue(indices.isEmpty());
    }

    @Test
    void testGetFileIndicesInvalidDirectory() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            getFileIndices("track", "invalid_directory_path");
        });

        assertEquals("The provided path is not a directory.", exception.getMessage());
    }
}