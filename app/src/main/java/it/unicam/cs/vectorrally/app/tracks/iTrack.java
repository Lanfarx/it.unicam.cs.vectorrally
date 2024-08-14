package it.unicam.cs.vectorrally.app.tracks;

import it.unicam.cs.vectorrally.app.movements.Position;

import java.util.List;

public interface iTrack {

    /**
     * Gets the length of the track
     *
     * @return the length of the track
     */
    int getLength();

    /**
     * Gets the width of the track
     *
     * @return the width of the track
     */
    int getWidth();

    /**
     * Gets the positions of the corresponding symbols in the track
     *
     * @param symbol the symbol
     * @return the positions of the corresponding symbols in the track
     */
    List<Position> getSymbolsPosition(TrackSymbol symbol);

    /**
     * Gets the symbol of the corresponding position in the track
     *
     * @param position the position
     * @return the symbol of the corresponding position in the track
     * @throws IllegalArgumentException if the position is out of the track
     */
    TrackSymbol getSymbolAtPosition(Position position);

    /**
     * Check if a position is inside the track borders.
     *
     * @param position the position to be checked
     * @return true if the position is inside the track borders.
     */
    boolean isInTrack(Position position);
}
