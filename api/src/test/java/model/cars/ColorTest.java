/*
 * Copyright <2024> <Lorenzo Marcantognini>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package model.cars;

import it.unicam.cs.vectorrally.api.model.cars.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testGetColorForAllEnums() {
        assertEquals("\033[31m", Color.RED.getColor());
        assertEquals("\033[34m", Color.BLUE.getColor());
        assertEquals("\033[32m", Color.GREEN.getColor());
        assertEquals("\033[33m", Color.YELLOW.getColor());
        assertEquals("\033[38;5;208m", Color.ORANGE.getColor());
        assertEquals("\033[35m", Color.MAGENTA.getColor());
        assertEquals("\033[38;5;205m", Color.PINK.getColor());
        assertEquals("\033[38;5;94m", Color.BROWN.getColor());
    }

    @Test
    void testEnumValues() {
        Color[] expectedValues = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.PINK, Color.BROWN};
        assertArrayEquals(expectedValues, Color.values());
    }

    @Test
    void testEnumValueOf() {
        assertEquals(Color.RED, Color.valueOf("RED"));
        assertEquals(Color.BLUE, Color.valueOf("BLUE"));
        assertEquals(Color.GREEN, Color.valueOf("GREEN"));
        assertEquals(Color.YELLOW, Color.valueOf("YELLOW"));
        assertEquals(Color.ORANGE, Color.valueOf("ORANGE"));
        assertEquals(Color.MAGENTA, Color.valueOf("MAGENTA"));
        assertEquals(Color.PINK, Color.valueOf("PINK"));
        assertEquals(Color.BROWN, Color.valueOf("BROWN"));
    }

    @Test
    void testEnumName() {
        assertEquals("RED", Color.RED.name());
        assertEquals("BLUE", Color.BLUE.name());
        assertEquals("GREEN", Color.GREEN.name());
        assertEquals("YELLOW", Color.YELLOW.name());
        assertEquals("ORANGE", Color.ORANGE.name());
        assertEquals("MAGENTA", Color.MAGENTA.name());
        assertEquals("PINK", Color.PINK.name());
        assertEquals("BROWN", Color.BROWN.name());
    }

    @Test
    void testEnumOrdinal() {
        assertEquals(0, Color.RED.ordinal());
        assertEquals(1, Color.BLUE.ordinal());
        assertEquals(2, Color.GREEN.ordinal());
        assertEquals(3, Color.YELLOW.ordinal());
        assertEquals(4, Color.ORANGE.ordinal());
        assertEquals(5, Color.MAGENTA.ordinal());
        assertEquals(6, Color.PINK.ordinal());
        assertEquals(7, Color.BROWN.ordinal());
    }
}