/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.controller.file.FileIndexExtractor;
import it.unicam.cs.vectorrally.api.controller.file.ResourceDirectoryFinder;

import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.List;

import static it.unicam.cs.vectorrally.api.view.ColorUtils.getPaintFromColor;

public class GUIRaceControllerFX implements iUIRaceController{
    private final Stage stage;
    private Group root;
    private Group trackG;
    private Group playersG;
    private boolean loaded;
    private final ResourceDirectoryFinder resourceDirectoryFinder;

    public GUIRaceControllerFX(Stage stage) {
        this.stage = stage;
        this.resourceDirectoryFinder = new ResourceDirectoryFinder();
        loaded = false;
        setupStage();
    }

    private void setupStage(){
        stage.setTitle("Vector Rally");

        root = new Group();
        trackG = new Group();
        playersG = new Group();
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");
        root.getChildren().add(new Label("Welcome to Vector Rally"));
        root.getChildren().addAll(trackG, playersG);
        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }

    private void updateTrack(RaceTrack track) {
        Platform.runLater(() -> {
            trackG.getChildren().clear();
            int cellSize = 20;
            for (int i = 0; i < track.getWidth(); i++) {
                for (int j = 0; j < track.getLength(); j++) {
                    Position position = new Position(i, j);
                    char symbol = track.getSymbolAtPosition(position).getSymbol();
                    Color color;
                    if (symbol == '|') {
                        color = Color.DARKGRAY; // Wall or obstacle
                    } else if (symbol == '_') {
                       color = Color.BISQUE;
                    } else if (symbol == '-') {
                        color = Color.LIGHTCORAL;
                    } else {
                        color = Color.LIGHTGRAY;
                    }

                    // Create a rectangle for the track cell
                    Rectangle cell = new Rectangle(cellSize, cellSize);
                    cell.setFill(color);
                    cell.setX(j * cellSize);
                    cell.setY(i * cellSize);

                    // Add the rectangle to the track group
                    trackG.getChildren().add(cell);
                }
            }
        });
    }

    private void updatePlayers(List<Player> players){
        Platform.runLater(() -> {
            playersG.getChildren().clear();
            for (Player player : players) {

                Circle playerCircle = new Circle();
                playerCircle.setRadius(10);
                playerCircle.setFill(getPaintFromColor(player.getPlayerCarColor()));
                playerCircle.setCenterX(player.getPosition().getY() * 10);
                playerCircle.setCenterY(player.getPosition().getX() * 10);
                playersG.getChildren().add(playerCircle);
            }
        });
    }

    @Override
    public void displayTrack(RaceTrack raceTrack, List<Player> players) {
        Platform.runLater(() -> {
            if (!loaded) {
                updateTrack(raceTrack);
                loaded = true;
            }
            updatePlayers(players);
        });
    }


    @Override
    public int chooseTrack() {
        Stage trackStage = new Stage();
        trackStage.setTitle("Select Track");
        String directoryPath = resourceDirectoryFinder.getDirectory();
        List<Integer> trackIndices = FileIndexExtractor.getFileIndices("track", directoryPath);
        ComboBox<Integer> trackComboBox = new ComboBox<>();
        trackComboBox.getItems().addAll(trackIndices);
        trackComboBox.setPromptText("Select a track");
        Button confirmButton = getFileConfirmButton(trackComboBox, trackStage);
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(new Label("Choose a track:"), trackComboBox, confirmButton);

        Scene scene = new Scene(layout, 300, 150);
        trackStage.setScene(scene);
        trackStage.showAndWait();
        return trackComboBox.getValue();
    }

    private Button getFileConfirmButton(ComboBox<Integer> fileComboBox, Stage stageFile) {
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            Integer selectedFile = fileComboBox.getValue();
            if (selectedFile != null) {
                stageFile.close();
            } else {
                displayMessage("Please select a file.");
            }
        });
        return confirmButton;
    }


    @Override
    public int chooseBots() {
        Stage botStage = new Stage();
        botStage.setTitle("Select Bots");
        String directoryPath = resourceDirectoryFinder.getDirectory();
        List<Integer> botIndices = FileIndexExtractor.getFileIndices("bot", directoryPath);
        ComboBox<Integer> botComboBox = new ComboBox<>();
        botComboBox.getItems().addAll(botIndices);
        botComboBox.setPromptText("Select a bot configuration file");
        Button confirmButton = getFileConfirmButton(botComboBox, botStage);
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(new Label("Choose a bot configuration file:"), botComboBox, confirmButton);

        Scene scene = new Scene(layout, 300, 150);
        botStage.setScene(scene);
        botStage.showAndWait();
        return botComboBox.getValue();
    }

    @Override
    public void displayPlayerTurn(Player player) {

    }

    @Override
    public void displayPlayerMove(Player player, Move move) {

    }

    @Override
    public void displayPlayerElimination(Player player) {

    }

    @Override
    public void displayVictory(Player player) {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayStart() {

    }

    @Override
    public void displayEnd() {

    }
}
