package it.unicam.cs.vectorrally.api.players;

import it.unicam.cs.vectorrally.api.cars.Car;

public class InteractivePlayer extends Player {

    /**
     * Creates an InteractivePlayer with the given Car
     *
     * @param playerCar the given car
     * @throws NullPointerException if the playerCar is null
     */
    public InteractivePlayer(Car playerCar) {
        super(playerCar);
    }
}
