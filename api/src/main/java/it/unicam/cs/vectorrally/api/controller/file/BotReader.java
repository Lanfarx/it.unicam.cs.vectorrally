package it.unicam.cs.vectorrally.api.controller.file;

import java.io.IOException;
import java.util.List;

public class BotReader implements iBotReader {

    @Override
    public int botCounter(String botName) throws IOException {
        List<String> botLines = iFileReader.readFile(botName);
        int counter = 0;
        for(String line : botLines){
            if (line.equals("bot")) counter++;
        }
        return counter;
    }
}
