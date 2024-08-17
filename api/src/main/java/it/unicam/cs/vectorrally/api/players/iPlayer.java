package it.unicam.cs.vectorrally.api.players;

import it.unicam.cs.vectorrally.api.cars.Color;
import it.unicam.cs.vectorrally.api.movements.Position;
import it.unicam.cs.vectorrally.api.movements.Vector;

public interface iPlayer {
    /**
     * Sets the acceleration of the player.
     *
     * @param acceleration the new acceleration
     * @throws NullPointerException if acceleration is null.
     */
    void setPlayerAcceleration(Vector acceleration);

    /**
     * Gets the acceleration of the player
     *
     * @return the color of the car
     */
    Vector getPlayerAcceleration();

    /**
     * Gets the color of the car
     *
     * @return the color of the car
     */
    Color getPlayerCarColor();

    /**
     * Gets the current player position
     *
     * @return the current position
     */
    Position getPosition();

    /**
     * Sets the player position on the track
     *
     * @param position the position the player will be located
     * @throws NullPointerException if the position is null
     */
    void setPosition(Position position);
}
