package it.unicam.cs.vectorrally.api.view;

public interface iUIController {

    /** Displays a given message
     *
     * @param message the given message
     */
    void displayMessage(String message);

    /**
     * Displays a configured start message
     */
    void displayStart();

    /**
     * Displays a configured end message
     */
    void displayEnd();

}
