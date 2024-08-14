package it.unicam.cs.vectorrally.app.cars;

import it.unicam.cs.vectorrally.app.movements.Vector;

public class Car implements iCar{

    private final CarColor color;
    private final Vector accelerationCar;

    /**
     * Creates a car based on the corresponding color
     *
     * @param color the color of the car
     * @throws NullPointerException if the color is null
     */
    public Car(CarColor color) {
        if(color == null) throw new NullPointerException("Color can't be null");
        this.color = color;
        this.accelerationCar = new Vector(0,0);
    }

    @Override
    public void setAcceleration(Vector acceleration) {
        if(acceleration == null) throw new NullPointerException("Acceleration can't be null");
        this.accelerationCar.setAx(acceleration.getAx());
        this.accelerationCar.setAy(acceleration.getAy());
    }

    @Override
    public Vector getAcceleration() {
        return accelerationCar;
    }

    @Override
    public CarColor getCarColor() {
        return color;
    }
}
