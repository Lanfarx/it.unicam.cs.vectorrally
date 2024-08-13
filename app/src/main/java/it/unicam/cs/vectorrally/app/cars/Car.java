package it.unicam.cs.vectorrally.app.cars;

import it.unicam.cs.vectorrally.app.movements.Vector;

public class Car implements iCar{
    /**
     * Sets the acceleration of the car.
     *
     * @param acceleration the new acceleration
     * @throws NullPointerException if the acceleration is null.
     */
    @Override
    public void setAcceleration(Vector acceleration) {

    }

    /**
     * Gets the acceleration of the car
     *
     * @return the acceleration of the car
     */
    @Override
    public Vector getAcceleration() {
        return null;
    }

    /**
     * Gets the color of the car
     *
     * @return the color of the car
     */
    @Override
    public CarColor getCarColor() {
        return null;
    }
}
