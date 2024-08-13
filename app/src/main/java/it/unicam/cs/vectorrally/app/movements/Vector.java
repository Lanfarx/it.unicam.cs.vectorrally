package it.unicam.cs.vectorrally.app.movements;

public class Vector implements iVector{
    /**
     * Gets the acceleration value x of the direction vector.
     *
     * @return the x coordinate
     */
    @Override
    public int getAx() {
        return 0;
    }

    /**
     * Gets the acceleration value y of the direction vector.
     *
     * @return the x coordinate
     */
    @Override
    public int getAy() {
        return 0;
    }

    /**
     * Sets the acceleration value x of the direction vector.
     *
     * @param x new Ax value
     */
    @Override
    public void setAx(int x) {

    }

    /**
     * Sets the acceleration value x of the direction vector.
     *
     * @param y new Ax value
     */
    @Override
    public void setAy(int y) {

    }

    /**
     * Get the direction value of the direction vector.
     *
     * @return the direction of the vector
     * @throws IllegalStateException if the direction is not accepted.
     */
    @Override
    public MoveDirection getDirection() {
        return null;
    }
}
