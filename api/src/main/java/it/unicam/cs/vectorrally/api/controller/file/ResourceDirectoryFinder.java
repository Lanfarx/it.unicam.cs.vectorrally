/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller.file;

/**
 * The {@code ResourceDirectoryFinder} class implements the {@code iDirectoryFinder} interface and provides functionality
 * to locate and return a directory path based on a given criterion, such as a file number or name.
 */
public class ResourceDirectoryFinder implements iDirectoryFinder{

    @Override
    public String getDirectory() {
        String resourceDirectory;
        String actualDirectory = System.getProperty("user.dir");
        System.out.println("Current directory: " + actualDirectory);  // Debug message
        if (actualDirectory.endsWith("app")) resourceDirectory = "../api/src/main/resources";
        else resourceDirectory = "api/src/main/resources";
        System.out.println("Resource directory: " + resourceDirectory);  // Debug message
        return resourceDirectory;
    }
}
