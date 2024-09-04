/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.model.cars.Color;
import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/**
 * The {@code UIRaceController} class implements the {@code iUIRaceController} interface and provides
 * functionality to interact with the user for the Vector Rally game. It handles the display of the game track,
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
            if (player.getPosition().equals(position)) {
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
        iUtils.printlnText("Write the number of the corresponding track file");
        return numberFileSelector();
    }

    @Override
    public int chooseBots() {
        iUtils.printlnText("Write the number of the corresponding bot file");
        return numberFileSelector();
    }

    /**
     * Prompts the user to enter a valid integer number.
     * Continues to prompt the user until a valid number is provided.
     *
     * @return An {@code int} representing the valid number entered by the user.
     */
    private int numberFileSelector() {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                iUtils.printlnText("Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return number;
    }

    @Override
    public void displayPlayerTurn(Player player){
        iUtils.printlnTextColored("Player's turn: ^", player.getPlayerCarColor().getColor());
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
    public void displayMessage(String message) {
        iUtils.printlnText(message);
    }

}
