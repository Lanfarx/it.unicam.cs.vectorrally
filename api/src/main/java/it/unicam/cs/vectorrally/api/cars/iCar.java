package it.unicam.cs.vectorrally.api.cars;

import it.unicam.cs.vectorrally.api.movements.Vector;

public interface iCar {

    /**
     * Sets the acceleration of the car.
     *
     * @param acceleration the new acceleration
     * @throws NullPointerException if the acceleration is null.
     */

    void setAcceleration(Vector acceleration);

    /**
     * Gets the acceleration of the car
     *
     * @return the acceleration of the car
     */

    Vector getAcceleration();

    /**
     * Gets the color of the car
     *
     * @return the color of the car
     */
    Color getCarColor();

}
