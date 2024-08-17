package it.unicam.cs.vectorrally.api.view;


public interface iUtils {

    /**
     * Prints a text on the CLI
     *
     * @param text the printed text
     */
    static void printText(String text){
        System.out.print(text);
    }

    /**
     * Prints a text on the CLI and starts a new line
     *
     * @param text the printed text
     */
    static void printlnText(String text){
        System.out.println(text);
    }

    /**
     * Prints a colored text on the CLI
     *
     * @param text the printed text
     */
    static void printTextColored(String text, String color){
        printText(color + text + "\u001B[0m");
    }

    /**
     * Prints a colored text on the CLI and starts a new line
     *
     * @param text the printed text
     */
    static void printlnTextColoredColored(String text, String color){
        printlnText(color + text + "\u001B[0m");
    }


}
