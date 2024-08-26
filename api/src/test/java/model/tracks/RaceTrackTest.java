/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.tracks;

import it.unicam.cs.vectorrally.api.model.movements.Position;
import it.unicam.cs.vectorrally.api.model.tracks.RaceTrack;
import it.unicam.cs.vectorrally.api.model.tracks.TrackSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RaceTrackTest {
    RaceTrack raceTrack;

    @BeforeEach
    void setUp() {
        TrackSymbol[][] raceTrackMatrix = {
                {TrackSymbol.CIRCUIT, TrackSymbol.START},
                {TrackSymbol.BORDER, TrackSymbol.END}
        };
        raceTrack = new RaceTrack(raceTrackMatrix);
    }

    @Test
    void testConstructorNullTrack() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RaceTrack(null);
        });
    }

    @Test
    void testGetLength() {
        assertEquals(2, raceTrack.getLength());
    }

    @Test
    void testGetWidth() {
        assertEquals(2, raceTrack.getWidth());
    }

    @Test
    void testGetSymbolsPosition() {
        List<Position> positions = raceTrack.getSymbolsPosition(TrackSymbol.CIRCUIT);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(new Position(0, 0)));
    }

    @Test
    void testGetSymbolAtPositionValid() {
        TrackSymbol symbol = raceTrack.getSymbolAtPosition(new Position(0, 1));
        assertEquals(TrackSymbol.START, symbol);
    }

    @Test
    void testGetSymbolAtPositionInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            raceTrack.getSymbolAtPosition(new Position(3, 3));
        });
    }

    @Test
    void testIsInTrackTrue() {
        assertTrue(raceTrack.isInTrack(new Position(1, 1)));
    }

    @Test
    void testIsInTrackFalse() {
        assertFalse(raceTrack.isInTrack(new Position(2, 2)));
    }
}