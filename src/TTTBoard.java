
/**
 * Manages the Tic Tac Toe board and game rules.
 */
public class TTTBoard {

    private char[][] board;

    public TTTBoard() {
        board = new char[3][3];
        resetBoard();
    }

    /**
     * Clears all positions on the board.
     */
    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    /**
     * Places a player's symbol on an empty tile.
     */
    public boolean placeMove(int row, int col, char player) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    /**
     * Checks whether either player has won.
     */
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return true;
            }

            if (board[0][i] != ' ' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    /**
     * Checks whether the board is full without a winner.
     */
    public boolean checkTie() {
        if (checkWin()) {
            return false;
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public char getTile(int row, int col) {
        return board[row][col];
    }
}
