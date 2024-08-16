package it.unicam.cs.vectorrally.app.players;

import it.unicam.cs.vectorrally.app.cars.Car;

public class BotPlayer extends  Player {
    /**
     * Creates a BotPlayer with the given Car
     *
     * @param playerCar the given car
     * @throws NullPointerException if the playerCar is null
     */
    public BotPlayer(Car playerCar) {
        super(playerCar);
    }
}
