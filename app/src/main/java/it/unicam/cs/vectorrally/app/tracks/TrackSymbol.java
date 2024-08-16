package it.unicam.cs.vectorrally.app.tracks;

public enum TrackSymbol implements iSymbol {
    START('-'), END('_'), BORDER('|'), CIRCUIT('.');

    private final char symbol;

    TrackSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {

        return symbol;
    }

    /**
     * Gets the real purpose of the corresponding symbol
     *
     * @param symbol the character that may represent a symbol in the track
     * @return the corresponding purpose of the symbol
     * @throws IllegalArgumentException if the char doesn't represent any symbol in the track.
     */
    public static TrackSymbol realTrackSymbol(char symbol) {
        for (TrackSymbol trackSymbol : TrackSymbol.values()) {
            if (trackSymbol.symbol == symbol) {
                return trackSymbol;
            }
        }
        throw new IllegalArgumentException("Symbol not in track");
    }
}
