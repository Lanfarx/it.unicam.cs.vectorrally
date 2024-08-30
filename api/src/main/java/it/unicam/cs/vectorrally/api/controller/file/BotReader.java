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

import java.io.IOException;
import java.util.List;

/**
 * The {@code BotReader} class implements {@code iBotReader} and provides functionality to read and count bot entries
 * from a specified file. It counts the number of bots defined in the given file by reading the content and counting
 * relevant entries.
 */
public class BotReader implements iBotReader {

    @Override
    public int botCounter(String botName) throws IOException {
        List<String> botLines = iFileReader.readFile(botName);
        int counter = 0;
        for(String line : botLines){
            if (line.equals("bot")) counter++;
        }
        if(counter < 1) {
            iUtils.printlnText("Bots number must be greater than 0, inserted " + ++counter);
        }
        return counter;
    }
}
