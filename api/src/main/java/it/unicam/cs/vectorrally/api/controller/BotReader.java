package it.unicam.cs.vectorrally.api.controller;

import java.io.IOException;
import java.util.List;

public class BotReader implements iBotReader{

    @Override
    public int botCounter(String botNum) throws IOException {
        List<String> botLines = iFileReader.readFile(botNum);
        int counter = 0;
        for(String line : botLines){
            if (line.equals("bot")) counter++;
        }
        return counter;
    }
}
