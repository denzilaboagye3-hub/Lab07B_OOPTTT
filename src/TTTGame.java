
/**
 * Manages Tic Tac Toe turns and game status.
 */
public class TTTGame {

    private TTTBoard board;
    private char currentPlayer;
    private boolean gameOver;

    public TTTGame() {
        board = new TTTBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    /**
     * Attempts to place the current player's symbol.
     */
    public boolean makeMove(int row, int col) {
        if (gameOver) {
            return false;
        }

        if (!board.placeMove(row, col, currentPlayer)) {
            return false;
        }

        if (board.checkWin() || board.checkTie()) {
            gameOver = true;
        } else {
            switchPlayer();
        }

        return true;
    }

    /**
     * Switches between X and O.
     */
    private void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    /**
     * Resets the game to its starting state.
     */
    public void restartGame() {
        board.resetBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public TTTBoard getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean hasWinner() {
        return board.checkWin();
    }

    public boolean isTie() {
        return board.checkTie();
    }
}
