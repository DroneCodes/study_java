package Array.fun;// This is a simple X and O game
import java.util.Scanner;

public class XandO {
    private char[][] board;
    private char currentPlayer;
    private int moves;
    private int[][] turns;

    public XandO() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        moves = 0;
        turns = new int[9][2]; // Store the row and column of each turn
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                turns[moves][0] = row;
                turns[moves][1] = col;
                moves++;
                return true;
            }
        }
        return false;
    }

    public boolean checkForWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2]) ||
                    (board[0][i] == board[1][i] && board[1][i] == board[2][i])) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        return moves == 9;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playTurn(Scanner scanner, String player1, String player2) {
        int row, col;
        System.out.println((currentPlayer == 'X') ? player1 : player2 + ", it's your turn!");
        row = scanner.nextInt() - 1;
        col = scanner.nextInt() - 1;
        while (!placeMark(row, col)) {
            System.out.println("Invalid position, try again.");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        }
        printBoard();
        if (checkForWin()) {
            System.out.println((currentPlayer == 'X') ? player1 : player2 + " wins!");
        } else if (isBoardFull()) {
            System.out.println("The game is a tie!");
        } else {
            changePlayer();
            playTurn(scanner, player1, player2); // Recurse to play the next turn
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XandO game = new XandO();
        String player1 = "Player 1";
        String player2 = "Player 2";
        game.playTurn(scanner, player1, player2);
    }
}