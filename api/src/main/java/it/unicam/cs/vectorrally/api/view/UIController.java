package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class UIController implements iUIRaceController {
    private final Scanner scanner;

    public UIController() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayStart() {
        iUtils.printlnText("WELCOME TO THE GAME OF VECTOR RALLY!");
    }

    @Override
    public void displayTrack(RaceTrack raceTrack, List<Player> players) {
        System.out.flush();
        for (int i = 0; i < raceTrack.getWidth(); i++) {
            for (int j = 0; j < raceTrack.getLength(); j++) ;
            //TODO
        }
    }

    @Override
    public void displayEnd() {
        iUtils.printlnText("WELCOME TO THE GAME OF VECTOR RALLY!");
    }

    @Override
    public String chooseTrack(List<String> trackNames) {
        iUtils.printlnText("Write the filepath of the track configuration file");
        //Passare file e ottenere track TODO
        return "";
    }

    @Override
    public int chooseBotPlayers(String filepath) throws IOException {
        iUtils.printlnText("Write the filepath of the bot configuration file");
        //Passare file e ottenre numero bot TODO
        return 0;
    }

    @Override
    public int chooseNumPlayers(int maxPlayers) {
        iUtils.printlnText("Choose number of interactive players: ");
        int intPlayers = scanner.nextInt();
        scanner.nextLine();
        while (intPlayers < 0 || intPlayers > maxPlayers) {
            iUtils.printlnText("Please enter a number between 0 and " + maxPlayers);
            intPlayers = scanner.nextInt();
            scanner.nextLine();
        }
        return intPlayers;
    }

    @Override
    public Color chooseColor(List<Color> colors) {
        iUtils.printlnText("Choose a color for your car: ");
        //TODO
        return null;
    }

    @Override
    public Move chooseNextMove(List<Move> moves) {
        //TODO
        return null;
    }

    @Override
    public void displayMessage(String message) {
        iUtils.printlnText(message);
    }

}
