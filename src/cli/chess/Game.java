package cli.chess;

import java.util.Scanner;

public class Game {

    //Starts game with user choices.
    public void startGame(String side) {
        System.out.println("Starting game for " + side + " side...");
    }

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {
        boolean playAgain;
        Scanner inputScanner = new Scanner(System.in);
        String input;

        Board board = new Board();
        board.showBoard();

        System.out.println("                           Welcome to Chess CLI.");
        System.out.println("                        Created by Joe Howell, 2017.");
        System.out.println("_________________________________________________________________________");
        System.out.println("");
        System.out.println("Please enter your choice of colour ('W' or 'B') to start.");
        playAgain = true;

        while (playAgain) {
            input = inputScanner.nextLine();
            System.out.println("_________________________________________________________________________");
            switch (input) {
                case "B":
                    startGame("B");
                    break;
                case "W":
                    startGame("W");
                    break;
                case "exit":
                    playAgain = false;
                    break;
                default:
                    System.out.println(input + " is not a valid input. Please try again.");

            }
        }
    }
}
