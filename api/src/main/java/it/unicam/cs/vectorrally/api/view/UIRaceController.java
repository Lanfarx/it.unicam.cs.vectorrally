/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Move;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.players.Player;
import it.unicam.cs.vectorrally.api.tracks.RaceTrack;

import java.util.Scanner;
import java.util.List;

/**
 * The {@code UIRaceController} class implements the {@code iUIRaceController} interface and provides
 * functionality to interact with the user for a racing game. It handles the display of the game track,
 * player interactions, and game configuration through a command-line interface.
 * <p>
 * This class uses a {@code Scanner} to read user inputs from the standard input stream.
 * </p>
 */
public class UIRaceController implements iUIRaceController {
    private final Scanner scanner;

    /**
     * Constructs a {@code UIRaceController} instance and initializes the {@code Scanner} for user input.
     */
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

    /**
     * Checks if any player is located at the specified position on the track and displays a marker.
     * <p>
     * This method iterates through the list of players to determine if any player's position matches the given position.
     * If a player is found at the position, it prints a colored marker ('^') to indicate the player's presence and returns {@code true}.
     * If no player is found at the position, it returns {@code false}.
     * </p>
     *
     * @param position The {@code Position} to check for player presence.
     * @param players A {@code List<Player>} containing all the players to check against.
     * @return {@code true} if a player is at the specified position; {@code false} otherwise.
     */
    private boolean isPlayerAtPosition(Position position, List<Player> players) {
        for (Player player : players) {
            if (player.getPosition().getX() == position.getX() && player.getPosition().getY() == position.getY()) {
                String colorCode = player.getPlayerCarColor().getColor();
                iUtils.printTextColored("^", colorCode);
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

    /**
     * Prompts the user to enter a number between 1 and 3 to select a file.
     *
     * @return An {@code int} representing the valid number selected by the user.
     */
    private int numberFileSelector() {
        int number;
        number = scanner.nextInt();
        scanner.nextLine();
        if (number < 1 || number > 3) {
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
    public void displayPlayerTurn(Player player){
        iUtils.printlnTextColored("Player's turn", player.getPlayerCarColor().getColor());
    }

    @Override
    public void displayPlayerMove(Player player, Move move){
        iUtils.printlnTextColored("Player's move is " + move.toString(), player.getPlayerCarColor().getColor());
    }

    @Override
    public void displayPlayerElimination(Player player) {
        iUtils.printlnTextColored("Player has been eliminated", player.getPlayerCarColor().getColor());
    }

    @Override
    public void displayVictory(Player player) {
        iUtils.printlnTextColored("PLAYER HAS WON", player.getPlayerCarColor().getColor());
    }

    @Override
    public Move chooseNextMove(List<Move> moves) {
        iUtils.printlnText("Choose your next move: ");
        //TODO
        return null;
    }

    @Override
    public Color chooseColor(List<Color> colors) {
        iUtils.printlnText("Choose a color for your car: ");
        //TODO
        return null;
    }

    @Override
    public void displayMessage(String message) {
        iUtils.printlnText(message);
    }

}
