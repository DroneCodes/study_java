package Array.fun;// This is a simple X and O game
import java.util.Scanner;

public class XandO {
    private Cell[][] board;
    private Player currentPlayer;
    private int moves;

    public XandO() {
        board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
        currentPlayer = Player.X;
        moves = 0;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j].getCellMark() + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public boolean placeMark(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == Cell.EMPTY &&
                placeMark(board, row, col, currentPlayer);
    }

    private boolean placeMark(Cell[][] board, int row, int col, Player player) {
        board[row][col] = player.getCellMark();
        moves++;
        return true;
    }

    public GameState playTurn(Scanner scanner, String player1Name, String player2Name) {
        System.out.println(currentPlayer + " (" + ((currentPlayer == Player.X) ? player1Name : player2Name) + "), it's your turn!");
        int row, col;
        do {
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            System.out.println("Invalid position, try again.");
        } while (!placeMark(row, col));
        printBoard();
        GameState state = checkGameState();
        if (state != GameState.PLAYING) {
            if (state == GameState.X_WON) {
                System.out.println(player1Name + " wins!");
            } else if (state == GameState.O_WON) {
                System.out.println(player2Name + " wins!");
            } else {
                System.out.println("The game is a tie!");
            }
        }
        return state;
    }

    public GameState checkGameState() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Cell.EMPTY) {
                return board[i][0].getPlayer() == Player.X ? GameState.X_WON : GameState.O_WON;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Cell.EMPTY) {
                return board[0][i].getPlayer() == Player.X ? GameState.X_WON : GameState.O_WON;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Cell.EMPTY) {
            return board[0][0].getPlayer() == Player.X ? GameState.X_WON : GameState.O_WON;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Cell.EMPTY) {
            return board[0][2].getPlayer() == Player.X ? GameState.X_WON : GameState.O_WON;
        }

        return moves == 9 ? GameState.TIE : GameState.PLAYING;
    }

    public enum Cell {
        EMPTY(' '), X('X'), O('O');

        private final char mark;

        Cell(char mark) {
            this.mark = mark;
        }

        public char getCellMark() {
            return mark;
        }

        public Player getPlayer() {
            return this == X ? Player.X : Player.O;
        }
    }

    public enum GameState {
        PLAYING, X_WON, O_WON, TIE
    }

    public enum Player {
        X, O;

        public Cell getCellMark() {
            return this == X ? Cell.X : Cell.O;
        }
    }

    private boolean canWin(Cell[][] board, Player player) {
        Cell mark = player.getCellMark();

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == Cell.EMPTY) {
                return true;
            }
            if (board[i][1] == mark && board[i][2] == mark && board[i][0] == Cell.EMPTY) {
                return true;
            }
            if (board[i][0] == mark && board[i][2] == mark && board[i][1] == Cell.EMPTY) {
                return true;
            }
        }

        // Check columns (similar logic as rows)
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == Cell.EMPTY) {
                return true;
            }
            // ... (similar checks for other columns)
        }

        // Check diagonals
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == Cell.EMPTY ||
                board[0][2] == mark && board[1][1] == mark && board[2][0] == Cell.EMPTY) {
            return true;
        }

        return false;
    }


    private int blockOpponentWin(Cell[][] board) {
        // Check if Player 1 can win and return the row/col for blocking move
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == Cell.X && board[i][1] == Cell.X && board[i][2] == Cell.EMPTY) {
                return i * 3 + 2; // Empty cell index (row 0, col 2)
            }
            // ... (similar checks for other cells)
        }

        return -1; // No blocking move needed
    }



    public static void main(String[] args) {
        XandO game = new XandO();
        Scanner scanner = new Scanner(System.in);
        String player1Name = "Player 1";
        String player2Name = "Player 2";
        GameState state;
        Player currentPlayer = Player.X; // Start with Player 1 (X)

        do {
            // Announce player based on currentPlayer and their mark
            String playerName = currentPlayer == Player.X ? player1Name : player2Name;
            String playerMark = currentPlayer.getCellMark().toString();
            System.out.println(playerName + " (" + playerMark + "), it's your turn!");
            state = game.playTurn(scanner, playerName, player2Name); // Pass both player names
            currentPlayer = currentPlayer == Player.X ? Player.O : Player.X; // Switch player for the next turn
            if (!state.equals(GameState.PLAYING)) {
                break;
            }
            // Clear any leftover newline character from invalid input
            scanner.nextLine();
        } while (state == GameState.PLAYING);
        scanner.close();
    }

}