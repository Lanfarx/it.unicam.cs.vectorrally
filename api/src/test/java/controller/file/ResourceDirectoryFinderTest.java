/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller.file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.unicam.cs.vectorrally.api.controller.file.ResourceDirectoryFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResourceDirectoryFinderTest {

    private ResourceDirectoryFinder resourceDirectoryFinder;
    private String originalUserDir;

    @BeforeEach
    void setUp() {
        originalUserDir = System.getProperty("user.dir");
        resourceDirectoryFinder = new ResourceDirectoryFinder();
    }

    @AfterEach
    void tearDown() {
        System.setProperty("user.dir", originalUserDir);
    }

    @Test
    void testGetDirectoryWhenEndsWithApp() {
        System.setProperty("user.dir", "/path/to/your/app");
        String expectedDirectory = "../api/src/main/resources";
        assertEquals(expectedDirectory, resourceDirectoryFinder.getDirectory());
    }

    @Test
    void testGetDirectoryWhenDoesNotEndWithApp() {
        System.setProperty("user.dir", "/path/to/your/project");
        String expectedDirectory = "api/src/main/resources";
        assertEquals(expectedDirectory, resourceDirectoryFinder.getDirectory());
    }
}
