/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.view;

import it.unicam.cs.vectorrally.api.controller.file.ResourceDirectoryFinder;

import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.List;

import static it.unicam.cs.vectorrally.api.controller.file.FileIndexExtractor.getFileIndices;
import static it.unicam.cs.vectorrally.api.view.ColorUtils.getPaintFromColor;

public class GUIRaceControllerFX implements iUIRaceController{
    private final Stage stage;
    private Group trackG;
    private Group playersG;
    private boolean loaded;
    private final ResourceDirectoryFinder resourceDirectoryFinder;
    private final int cellSize;

    public GUIRaceControllerFX(Stage stage) {
        this.stage = stage;
        this.cellSize = 20;
        this.resourceDirectoryFinder = new ResourceDirectoryFinder();
        loaded = false;
        setupStage();
    }

    private void setupStage(){
        stage.setTitle("Vector Rally");

        BorderPane borderPane = new BorderPane();
        trackG = new Group();
        playersG = new Group();
        Group root = new Group();
        root.getChildren().addAll(trackG,playersG);

        StackPane trackPane = new StackPane(root);
        borderPane.setCenter(trackPane);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
    }

    private void updateTrack(RaceTrack track) {
        Platform.runLater(() -> {
            trackG.getChildren().clear();
            for (int i = 0; i < track.getWidth(); i++) {
                for (int j = 0; j < track.getLength(); j++) {
                    Position position = new Position(i, j);
                    char symbol = track.getSymbolAtPosition(position).getSymbol();
                    Rectangle trackRectangle = getTrackRectangle(symbol, j, i);
                    trackG.getChildren().add(trackRectangle);
                }
            }
            stage.sizeToScene();
            stage.show();
        });
    }

    private Rectangle getTrackRectangle(char symbol, int j, int i) {
        Color color = switch (symbol) {
            case '|' -> Color.DARKGRAY;
            case '_' -> Color.TOMATO;
            case '-' -> Color.ANTIQUEWHITE;
            default -> Color.LIGHTGRAY;
        };
        Rectangle trackRectangle = new Rectangle(cellSize, cellSize);
        trackRectangle.setFill(color);
        trackRectangle.setX(j * cellSize);
        trackRectangle.setY(i * cellSize);
        trackRectangle.setStroke(Color.BLACK);
        return trackRectangle;
    }

    private void updatePlayers(List<Player> players) {
        Platform.runLater(() -> {
            playersG.getChildren().clear();

            for (Player player : players) {
                Circle playerCircle = getPlayerCircle(player, cellSize);
                playersG.getChildren().add(playerCircle);
            }
        });
    }

    private Circle getPlayerCircle(Player player, int cellSize) {
        Position position = player.getPosition();
        Paint playerPaint = getPaintFromColor(player.getPlayerCarColor());

        Circle playerCircle = new Circle();
        playerCircle.setRadius(10);
        playerCircle.setFill(playerPaint);
        playerCircle.setCenterX((position.getY() + 0.5) * cellSize);
        playerCircle.setCenterY((position.getX() + 0.5) * cellSize);
        return playerCircle;
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
    public void displayInvalidTrackFile() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Track File");
            alert.setHeaderText(null);
            alert.setContentText("The selected file is empty, cannot create a track with this. Please choose another file.");
            alert.showAndWait();
        });
    }

    @Override
    public int chooseTrack() {
        Stage trackStage = new Stage();
        trackStage.setTitle("Select Track");
        String directoryPath = resourceDirectoryFinder.getDirectory();
        List<Integer> trackIndices = getFileIndices("track", directoryPath);
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
        List<Integer> botIndices = getFileIndices("bot", directoryPath);
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
        Platform.runLater(() -> {
            Alert eliminationAlert = new Alert(Alert.AlertType.INFORMATION);
            eliminationAlert.setTitle("Player Eliminated");
            eliminationAlert.setHeaderText(null);

            Text playerMessage = new Text("Player " + player.getPlayerCarColor() + " has been eliminated!");
            playerMessage.setFill(getPaintFromColor(player.getPlayerCarColor()));

            VBox dialogPaneContent = new VBox();
            dialogPaneContent.setAlignment(Pos.CENTER);
            dialogPaneContent.getChildren().add(playerMessage);

            eliminationAlert.getDialogPane().setContent(dialogPaneContent);
            eliminationAlert.show();
        });
    }

    @Override
    public void displayVictory(Player player) {
        Platform.runLater(() -> {
            Stage victoryStage = new Stage();
            victoryStage.setTitle("Victory");

            Label victoryLabel = new Label("Congratulations " + player.getPlayerCarColor() + ", you have won!");
            victoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            victoryLabel.setTextFill(getPaintFromColor(player.getPlayerCarColor()));

            VBox vbox = new VBox(20, victoryLabel);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(20));

            Scene victoryScene = new Scene(vbox, 600, 200);
            victoryStage.setScene(victoryScene);
            victoryStage.show();
        });
    }

    @Override
    public void displayMessage(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    @Override
    public void displayStart() {
        Label welcomeLabel = new Label("Welcome to Vector Rally");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        welcomeLabel.setTextFill(Color.BLACK);
        VBox vbox = new VBox(welcomeLabel);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20, 0, 0, 0));
        BorderPane rootPane = (BorderPane) stage.getScene().getRoot();
        rootPane.setTop(vbox);
    }

    @Override
    public void displayEnd() {
        Platform.runLater(() -> {
            Label endLabel = new Label("THE GAME HAS ENDED, CONGRATULATIONS TO EVERYONE WHO PLAYED");
            endLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            endLabel.setTextFill(Color.BLACK);
            endLabel.setAlignment(Pos.CENTER);

            VBox vbox = getClosingGameBox(endLabel);

            Scene endScene = new Scene(vbox, 1000, 500);
            stage.setScene(endScene);
            stage.show();
        });
    }

    private VBox getClosingGameBox(Label endLabel) {
        Button closeButton = new Button("Close Game");
        closeButton.setOnAction(e -> {
            Stage currentStage = (Stage) closeButton.getScene().getWindow();
            currentStage.close();
            Platform.exit();
        });
        VBox vbox = new VBox(20, endLabel, closeButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        return vbox;
    }
}
