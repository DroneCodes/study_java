package Array.fun;

import java.util.Scanner;

/**
 * This class represents a simple game of Tic Tac Toe (X and O).
 * It uses a 2D char array to represent the game board and a char to represent the current player.
 * The game continues until a player wins or the board is full, at which point a new game starts.
 */
public class XandO {
    private char[][] board;  // The game board.
    private char currentPlayer;  // The player who is currently making a move.

    /**
     * Constructor for the XandO class.
     * Initializes the game board and sets the current player to 'X'.
     */
    public XandO() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    /**
     * Initializes the game board with ' ' to represent empty spaces and adds borders.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j ++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Prints the game board to the console.
     */
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    /**
     * Changes the current player from 'X' to 'O', or from 'O' to 'X'.
     */
    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    /**
     * Places the current player's mark at the specified row and column on the game board.
     * Returns true if the mark was successfully placed, and false otherwise.
     */
    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3 && col < 3) {
            if (board[row][col] == ' ') {  // Changed '-' to ' '
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the current player has won the game.
     * Returns true if the current player has won, and false otherwise.
     */
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    /**
     * Checks if the current player has won by filling a diagonal on the game board.
     * Returns true if the current player has won, and false otherwise.
     */
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || checkRowCol(board[0][2], board[1][1], board[2][0]) == true);
    }

    /**
     * Checks if the current player has won by filling a column on the game board.
     * Returns true if the current player has won, and false otherwise.
     */
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the current player has won by filling a row on the game board.
     * Returns true if the current player has won, and false otherwise.
     */
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the three chars are the same (and not '-').
     * This is used to check if the current player has filled a row, column, or diagonal on the game board.
     * Returns true if the three chars are the same, and false otherwise.
     */
    private boolean checkRowCol(char c, char c1, char c2) {
        return ((c != '-') && (c == c1) && (c == c2));
    }

    /**
     * Checks if the game board is full.
     * Returns true if the board is full, and false otherwise.
     */
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j ++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    /**
     * The main method that runs the game.
     * It creates a new game and then enters a loop where it continuously prompts the current player for their move,
     * checks if the game is won or tied after each move, and starts a new game if necessary.
     * The game continues indefinitely until it is manually stopped.
     */

    /**
     * Displays all possible winning combinations on the game board.
     */
    public void displayWinningCombinations() {
        System.out.println("Here are all possible winning combinations:");
        System.out.print("Diagonal:");
        System.out.print("\n| X | - | - |");
        System.out.print("\n| - | X | - |");
        System.out.print("\n| - | - | X |");

        System.out.println("\n");

        System.out.print("Columns:");
        System.out.print("\n| - | X | - |");
        System.out.print("\n| - | X | - |");
        System.out.print("\n| - | X | - |");
        System.out.println("\n");
        System.out.print("Rows:");
        System.out.print("\n| - | - | - |");
        System.out.print("\n| X | X | X |");
        System.out.print("\n| - | - | - |");
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("The game board looks like this: \n1 2 3\n4 5 6\n7 8 9");
        System.out.println("Each player will enter the number of the spot where they want to place their mark.");
        System.out.println("The first player to get 3 of their marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("When all 9 spots are filled, the game is over. If no player has 3 marks in a row, the game ends in a tie.\n");
        XandO game = new XandO();
        game.displayWinningCombinations();

        System.out.println("Player 1, enter your name:");
        String player1 = scanner.nextLine();
        System.out.println("Player 2, enter your name:");
        String player2 = scanner.nextLine();



        do {
            System.out.println("Player " + (game.currentPlayer == 'X' ? player1 : player2) + ", enter an empty row and column to place your mark!");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            while (!game.placeMark(row, col)) {
                System.out.println("Invalid position, try again.");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            game.printBoard();


            if (game.checkForWin()) {
                System.out.println("Player " + (game.currentPlayer == 'X' ? player1 : player2) + " wins!");
                game = new XandO();
            } else if (game.isBoardFull()) {
                System.out.println("The game is a tie!");
                game = new XandO();
            }

            game.changePlayer(); // Change player after checking for win or tie

            System.out.println("Player " + (game.currentPlayer == 'X' ? player1 : player2) + ", it's your turn!");

        } while (true);
    }
}