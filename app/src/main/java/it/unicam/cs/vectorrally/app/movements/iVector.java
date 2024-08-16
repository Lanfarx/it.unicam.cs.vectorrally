package it.unicam.cs.vectorrally.app.movements;

public interface iVector {
    /**
     * Gets the acceleration value x of the direction vector.
     *
     * @return the x coordinate
     */
    int getAx();

    /**
     * Gets the acceleration value y of the direction vector.
     *
     * @return the x coordinate
     */

    int getAy();

    /**
     * Sets the acceleration value x of the direction vector.
     *
     * @param x new Ax value
     */

    void setAx(int x);

    /**
     * Sets the acceleration value x of the direction vector.
     *
     * @param y new Ax value
     */

    void setAy(int y);

    /**
     * Sets the direction value of the direction vector.
     *
     * @return the direction of the vector
     */

    MoveDirection getDirection();
}
