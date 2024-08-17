package it.unicam.cs.vectorrally.api.movements;

public class Move implements iMove{

    private final Vector acceleration;
    private final Position position;

    /**
     * Creates a move based on the given acceleration and position
     *
     * @param acceleration the given acceleration for the move
     * @param position the given position
     */
    public Move(Vector acceleration, Position position) {
        this.acceleration = acceleration;
        this.position = position;
    }

    @Override
    public Vector getAcceleration() {
        return this.acceleration;
    }

    @Override
    public Position getStartingPosition() {
        return this.position;
    }

    @Override
    public Position getNewPosition() {
       return new Position(this.position.getX() + this.acceleration.getAx(), this.position.getY() + this.acceleration.getAy());
    }
}
