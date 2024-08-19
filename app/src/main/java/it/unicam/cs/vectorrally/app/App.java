package it.unicam.cs.vectorrally.app;

import it.unicam.cs.vectorrally.api.controller.GameEngine;
import it.unicam.cs.vectorrally.api.view.UIRaceController;

public class App {
    public static void main(String[] args) {
        try {
            UIRaceController uiController = new UIRaceController();

            GameEngine gameEngine = new GameEngine(uiController);
            gameEngine.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}