/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.controller.file;

import it.unicam.cs.vectorrally.api.view.iUtils;

import java.io.File;

/**
 * The {@code AbstractFileTracker} class implements the {@code iFileTracker} interface and serves as an abstract base
 * class for tracking files with a specific prefix. It utilizes a {@code ResourceDirectoryFinder} to locate files
 * within a resource directory.
 */
public abstract class AbstractFileTracker implements iFileTracker {
    private final ResourceDirectoryFinder resourceDirectoryFinder;

    /**
     * Constructs an {@code AbstractFileTracker} with the specified resource directory finder.
     *
     * @param resourceDirectoryFinder the {@code ResourceDirectoryFinder} used to locate files in the resource directory
     * @throws NullPointerException if {@code resourceDirectoryFinder} is {@code null}
     */
    public AbstractFileTracker(ResourceDirectoryFinder resourceDirectoryFinder) {
        if (resourceDirectoryFinder == null) {
            throw new NullPointerException("ResourceDirectoryFinder can't be null");
        }
        this.resourceDirectoryFinder = resourceDirectoryFinder;
    }

    /**
     * Retrieves the file prefix used to identify files.
     *
     * @return a {@code String} representing the file prefix
     */
    protected abstract String getFilePrefix();

    @Override
    public String findFile(int number) {
        String filename = getFilePrefix() + number + ".txt";
        String filePath = resourceDirectoryFinder.getDirectory() + File.separator + filename;
        File file = new File(filePath);
        iUtils.printlnText("Trying to find file: " + filePath);
        if (file.exists()) {
            iUtils.printlnText("File found: " + file.getPath());
            return file.getPath();
        } else {
            iUtils.printlnText("File not found: " + filename);
            return null;
        }
    }
}
