/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.movements;

import it.unicam.cs.vectorrally.api.model.cars.Car;
import it.unicam.cs.vectorrally.api.model.cars.Color;
import it.unicam.cs.vectorrally.api.model.players.BotPlayer;
import it.unicam.cs.vectorrally.api.model.players.Player;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import it.unicam.cs.vectorrally.api.model.movements.Move;
import it.unicam.cs.vectorrally.api.model.movements.MoveCalculator;
import it.unicam.cs.vectorrally.api.model.movements.Vector;
import it.unicam.cs.vectorrally.api.model.movements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCalculatorTest {

    private MoveCalculator moveCalculator;
    private RaceTrack raceTrack;
    private List<Player> players;
    private Player player;

    @BeforeEach
    void setUp() {
        moveCalculator = new MoveCalculator();
        TrackSymbol[][] trackSymbols = {
                {TrackSymbol.START, TrackSymbol.CIRCUIT, TrackSymbol.END},
                {TrackSymbol.CIRCUIT, TrackSymbol.CIRCUIT, TrackSymbol.CIRCUIT},
                {TrackSymbol.BORDER, TrackSymbol.CIRCUIT, TrackSymbol.BORDER}
        };
        raceTrack = new RaceTrack(trackSymbols);
        players = new ArrayList<>();
        player = new BotPlayer(new Car(Color.RED));
        player.setPosition(new Position(1, 1));
        player.setPlayerAcceleration(new Vector(0, 1));
        players.add(player);
    }

    @Test
    void testAvailableMoves() {
        List<Move> moves = moveCalculator.availableMoves(player, raceTrack, players);
        assertNotNull(moves);
        assertFalse(moves.isEmpty());
        assertTrue(moves.stream().anyMatch(move -> move.getStartingPosition().equals(new Position(1, 1))));
    }
}
