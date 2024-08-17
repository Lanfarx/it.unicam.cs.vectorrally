package it.unicam.cs.vectorrally.api.tracks;

import it.unicam.cs.vectorrally.api.movements.Position;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack implements iTrack{

    private final int length;
    private final int width;
    private final TrackSymbol[][] RaceTrack;

    /**
     * Creates a RaceTrack based on the given matrix that corresponds to a track
     *
     * @param raceTrack matrix that corresponds to a track
     * @throws IllegalArgumentException if the matrix is null or empty
     */
    public RaceTrack(TrackSymbol[][] raceTrack) {
        if(raceTrack == null || raceTrack.length == 0 || raceTrack[0].length == 0) throw new IllegalArgumentException("Track is not valid");
        this.RaceTrack = raceTrack;
        this.length = RaceTrack[0].length;
        this.width = RaceTrack.length;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public List<Position> getSymbolsPosition(TrackSymbol symbol) {
        List<Position> currentSymbolsPositions = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (this.RaceTrack[i][j] == symbol) currentSymbolsPositions.add(new Position(i, j));
            }
        }
        return currentSymbolsPositions;
    }

    @Override
    public TrackSymbol getSymbolAtPosition(Position position) {
        if(!isInTrack(position)) throw new IllegalArgumentException("Position is not in track");
        return this.RaceTrack[position.getX()][position.getY()];
    }

    @Override
    public boolean isInTrack(Position position) {
        return (position.getX() >= 0 && position.getX() < this.width && position.getY() >= 0 && position.getY() < this.length);
    }
}
