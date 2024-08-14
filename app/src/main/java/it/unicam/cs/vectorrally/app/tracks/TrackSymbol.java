package it.unicam.cs.vectorrally.app.tracks;

public enum TrackSymbol implements iSymbol {
    START('-'), END('_'), BORDER('|'), CIRCUIT('.');

    private final char symbol;

    private TrackSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
