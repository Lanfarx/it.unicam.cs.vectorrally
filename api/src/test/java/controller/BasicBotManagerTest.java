/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller;

import static org.junit.jupiter.api.Assertions.*;

import it.unicam.cs.vectorrally.api.controller.BasicBotManager;
import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicBotManagerTest {

    private BasicBotManager botManager;

    @BeforeEach
    void setUp() {
        botManager = new BasicBotManager();
    }

    @Test
    void testNextMoveWithValidMoves() {
        Move move1 = new Move(new Vector(1, 0), new Position(0, 0));
        Move move2 = new Move(new Vector(0, 1), new Position(0, 0));
        List<Move> moves = Arrays.asList(move1, move2);

        for (int i = 0; i < 10; i++) {
            Move selectedMove = botManager.nextMove(moves);
            assertTrue(moves.contains(selectedMove), "The selected move should be in the list of available moves.");
        }
    }

    @Test
    void testNextMoveWithEmptyList() {
        List<Move> moves = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> {
            botManager.nextMove(moves);
        }, "Calling nextMove with an empty list should throw IllegalArgumentException.");
    }
}