/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.model.players;

import it.unicam.cs.vectorrally.api.model.cars.Car;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import it.unicam.cs.vectorrally.api.model.cars.Color;

/**
 * The {@code Player} class represents a player in the racing game.
 * It implements the {@code iPlayer} interface and is characterized by its car and position on the track.
 */
public abstract class Player implements iPlayer {

    protected Position playerPosition;
    protected Car playerCar;

    /**
     * Creates a {@code Player} with the given car.
     *
     * @param playerCar The {@code Car} that the player will use. This cannot be {@code null}.
     * @throws NullPointerException If {@code playerCar} is {@code null}.
     */
    public Player(Car playerCar) {
        if (playerCar == null) {
            throw new NullPointerException("PlayerCar can't be null");
        }
        this.playerCar = playerCar;
        this.playerPosition = new Position(0, 0);
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
    public Color getPlayerCarColor() {
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
