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
 * The {@code BotFileTracker} class extends {@code AbstractFileTracker} and provides functionality for tracking bot files.
 * It utilizes the base class's file tracking capabilities and specifies the prefix for bot files.
 */
public class BotFileTracker extends AbstractFileTracker {

    /**
     * Constructs a {@code BotFileTracker} with the specified resource directory finder.
     *
     * @param resourceDirectoryFinder the {@code ResourceDirectoryFinder} used to locate bot files in the resource directory
     * @throws NullPointerException if {@code resourceDirectoryFinder} is {@code null}
     */
    public BotFileTracker(ResourceDirectoryFinder resourceDirectoryFinder) {
        super(resourceDirectoryFinder);
    }

    @Override
    protected String getFilePrefix() {
        return "bot";
    }
}
