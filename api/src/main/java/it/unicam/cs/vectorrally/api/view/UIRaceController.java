package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.Scanner;
import java.util.List;

public class UIRaceController implements iUIRaceController {
    private final Scanner scanner;

    public UIRaceController() {
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
            for (int j = 0; j < raceTrack.getLength(); j++) {
                Position position = new Position(i, j);
                if (!isPlayerAtPosition(position, players)){
                    iUtils.printText(String.valueOf(raceTrack.getSymbolAtPosition(position).getSymbol()));
                }
            }
            iUtils.printlnText("");
        }
    }

    private boolean isPlayerAtPosition(Position position, List<Player> players){
        for (Player player : players) {
            if (player.getPosition().equals(position)) {
                String colorCode = player.getPlayerCarColor().getColor();
                String playerSymbol = colorCode + '^' + "\033[0m";
                iUtils.printText(playerSymbol);
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayEnd() {
        iUtils.printlnText("THE GAME IS ENDED, CONGRATULATIONS TO EVERYONE WHO PLAYED");
    }

    @Override
    public int chooseTrack() {
        iUtils.printlnText("Write the number of the corresponding track file from 1 to 3");
        return numberFileSelector();
    }

    @Override
    public int chooseBots() {
        iUtils.printlnText("Write the number of the corresponding bot file from 1 to 3");
        return numberFileSelector();
    }

    private int numberFileSelector(){
        int number = scanner.nextInt();
        scanner.nextLine();
        while(number < 1 || number > 3) {
            iUtils.printlnText("Please enter a valid number between 1 and 3");
            number = scanner.nextInt();
            scanner.nextLine();
        }
        return number;
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

    public void displayPlayerTurn(Player player){
        String playerSymbolColorCode = player.getPlayerCarColor().getColor();
        iUtils.printlnText("Player " + playerSymbolColorCode + "'s turn" + "\033[0m");
    }

    @Override
    public void displayPlayerElimination(Player player) {
        String playerSymbolColorCode = player.getPlayerCarColor().getColor();
        iUtils.printlnText("Player " + playerSymbolColorCode + "' has been eliminated" + "\033[0m");
    }

    @Override
    public void displayVictory(Player player) {
        String playerSymbolColorCode = player.getPlayerCarColor().getColor();
        iUtils.printlnText("Player " + playerSymbolColorCode + " has WON!!!" + "\033[0m");
    }

    @Override
    public Move chooseNextMove(List<Move> moves) {
        iUtils.printlnText("Choose your next move: ");
        //TODO
        return null;
    }

    @Override
    public void displayMessage(String message) {
        iUtils.printlnText(message);
    }

}
