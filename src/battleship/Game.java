package battleship;

import java.util.Scanner;

public class Game {
    Board p1Board;
    Board p2Board;
    Player activePlayer;
    Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        p1Board = new Board(scanner);
        p2Board = new Board(scanner);
        activePlayer = Player.Player1;
    }

    public void play() {
        //Setup
        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        p1Board.setUpBoard();
        System.out.println();
        System.out.println("Press Enter and pass the move to another player");
        System.out.print("...");
        scanner.nextLine();
        System.out.println("Player 2, place your ships to the game field");
        System.out.println();
        p2Board.setUpBoard();
        System.out.println();
        System.out.println("Press Enter and pass the move to another player");
        System.out.print("...");
        scanner.nextLine();

        //play through game, swapping player each turn
        while (true) {
            System.out.println();
            //display the relevant board information to the player who is active
            if (activePlayer == Player.Player1) {
                p2Board.printPublicBoard();
                System.out.println("---------------------");
                p1Board.printPlayerBoard();
            } else {
                p1Board.printPublicBoard();
                System.out.println("---------------------");
                p2Board.printPlayerBoard();
            }
            System.out.println();
            System.out.println(activePlayer.name + ", it's your turn: ");
            boolean result;
            if (activePlayer == Player.Player1) {
                result = p2Board.takeTurn();
            } else {
                result = p1Board.takeTurn();
            }
            //if active player eliminated all opponent's ships, they win
            if (result) {
                break;
            }
            //otherwise game continues
            switchActivePlayer();
            System.out.println("Press Enter and pass the move to another player");
            System.out.print("...");
            scanner.nextLine();
        }
    }

    private void switchActivePlayer() {
        if (activePlayer == Player.Player1) {
            activePlayer = Player.Player2;
        } else {
            activePlayer = Player.Player1;
        }
    }

    private enum Player {
        Player1("Player 1"),
        Player2("Player 2");

        final String name;

        Player(String name) {
            this.name = name;
        }
    }
}
