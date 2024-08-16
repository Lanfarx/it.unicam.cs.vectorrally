package it.unicam.cs.vectorrally.app.movements;

public interface iMove {

    /**
     * Gets the acceleration
     *
     * @return the acceleration vector
     */
    Vector getAcceleration();

    /**
     * Gets the starting position of the move
     *
     * @return the starting position of the move
     */
    Position getStartingPosition();

    /**
     * Gets the new position after the vector has been calculated
     *
     * @return the new position
     */
    Position getNewPosition();
}
