/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.vectorrally.api.movements;

import static java.lang.Integer.signum;

/**
 * The {@code Vector} class implements the {@code iVector} interface and represents a two-dimensional vector
 * with acceleration components {@code Ax} and {@code Ay}. This class provides methods to access and modify
 * the vector's components.
 */
public class Vector implements iVector {
    private int Ax;
    private int Ay;

    /**
     * Constructs a {@code Vector} instance with the specified acceleration values for {@code Ax} and {@code Ay}.
     *
     * @param Ax the acceleration value along the x-axis
     * @param Ay the acceleration value along the y-axis
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

    @Override
    public String toString(){
        return "Ax: " + Ax + ", Ay: " + Ay;
    }
}
