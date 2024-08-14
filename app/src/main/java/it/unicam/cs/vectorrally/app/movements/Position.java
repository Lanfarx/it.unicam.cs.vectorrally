package it.unicam.cs.vectorrally.app.movements;

public class Position implements iPosition {

    private int x;
    private int y;

    /**
     * Creates a position based on the values x and y
     *
     * @param x the x value
     * @param y the y value
     * @throws IllegalArgumentException if the x or y are not valid
     */
    public Position(int x, int y) {
        if(x < 0 || y < 0) throw new IllegalArgumentException("Axes not valid");
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
