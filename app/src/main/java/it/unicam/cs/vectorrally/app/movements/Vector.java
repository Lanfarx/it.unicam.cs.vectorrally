package it.unicam.cs.vectorrally.app.movements;

import static java.lang.Integer.signum;

public class Vector implements iVector{
    private int Ax;
    private int Ay;

    /**
     * Creates a vector having the given Ax and Ay.
     *     *
     * @param Ax the Ax value of the vector
     * @param Ay the Ay value of the vector
     */
    public Vector(int Ax, int Ay) {
        this.Ax = Ax;
        this.Ay = Ay;
    }

    @Override
    public int getAx() {
        return this.Ax;
    }

    @Override
    public int getAy() {
        return this.Ay;
    }

    @Override
    public void setAx(int x) {
        this.Ax = x;
    }

    @Override
    public void setAy(int y) {
        this.Ay = y;
    }

    @Override
    public MoveDirection getDirection() {
            // The return value of these two below is -1 if the specified value is negative;
            // 0 if the specified value is zero; and 1 if the specified value is positive.
            int signX = signum(Ax);
            int signY = signum(Ay);
            if (signX == 0 && signY == 0) return MoveDirection.NONE; // (0 , 0)
            if (signX == 0) return (signY > 0) ? MoveDirection.UP : MoveDirection.DOWN; // (0 , 1/-1)
            if (signY == 0) return (signX > 0) ? MoveDirection.RIGHT : MoveDirection.LEFT; // (1/-1 , 0)
            if (signX == 1) return (signY == 1) ? MoveDirection.UP_RIGHT : MoveDirection.DOWN_RIGHT; // (1 , 1/-1)
            return (signY == 1) ? MoveDirection.UP_LEFT : MoveDirection.DOWN_LEFT; // (-1/1 , 1)
    }
}
