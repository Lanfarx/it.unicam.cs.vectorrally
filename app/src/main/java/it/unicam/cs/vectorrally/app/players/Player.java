package it.unicam.cs.vectorrally.app.players;

import com.sun.jdi.ClassType;
import it.unicam.cs.vectorrally.app.cars.Car;
import it.unicam.cs.vectorrally.app.cars.CarColor;
import it.unicam.cs.vectorrally.app.movements.Position;
import it.unicam.cs.vectorrally.app.movements.Vector;

public abstract class Player implements iPlayer{

    protected Position playerPosition;
    protected Car playerCar;

    /**
     * Creates a Player with the given Car
     *
     * @param playerCar the given car
     * @throws NullPointerException if the playerCar is null
     */
    public Player (Car playerCar){
        if(playerCar == null) throw new NullPointerException("PlayerCar can't be null");
        this.playerCar = playerCar;
        this.playerPosition = new Position(0,0);
    }

    @Override
    public void setPlayerAcceleration(Vector acceleration) {
        if(acceleration == null) throw new NullPointerException("Acceleration can't be null");
        this.playerCar.setAcceleration(acceleration);
    }

    @Override
    public Vector getPlayerAcceleration() {
        return this.playerCar.getAcceleration();
    }

    @Override
    public CarColor getPlayerCarColor() {
        return this.playerCar.getCarColor();
    }

    @Override
    public Position getPosition() {
        return this.playerPosition;
    }

    @Override
    public void setPosition(Position playerPosition) {
        if(playerPosition == null) throw new NullPointerException("PlayerPosition can't be null");
        this.playerPosition = playerPosition;
    }
}
