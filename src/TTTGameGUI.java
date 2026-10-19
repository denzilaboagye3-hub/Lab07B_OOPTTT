
import javax.swing.*;
import java.awt.*;

/**
 * Swing GUI for the OOP Tic Tac Toe game.
 */
public class TTTGameGUI extends JFrame {

    private TTTGame game;
    private TTTTileButton[][] tiles;
    private JLabel statusLabel;

    public TTTGameGUI() {
        game = new TTTGame();
        tiles = new TTTTileButton[3][3];

        setTitle("Tic Tac Toe");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        createBoard();
        createControlPanel();
        updateDisplay();
    }

    /**
     * Creates the 3x3 board of custom tile buttons.
     */
    private void createBoard() {
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                TTTTileButton button = new TTTTileButton(row, col);
                tiles[row][col] = button;

                button.addActionListener(e -> handleMove(
                        button.getRow(), button.getCol()));

                boardPanel.add(button);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    /**
     * Creates the status label and control buttons.
     */
    private void createControlPanel() {
        JPanel controlPanel = new JPanel(new BorderLayout());

        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonPanel = new JPanel();

        JButton restartButton = new JButton("New Game");
        JButton quitButton = new JButton("Quit");

        restartButton.addActionListener(e -> restartGame());

        quitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Confirm Quit",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        buttonPanel.add(restartButton);
        buttonPanel.add(quitButton);

        controlPanel.add(statusLabel, BorderLayout.NORTH);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * Processes a move using the TTTGame object.
     */
    private void handleMove(int row, int col) {

        boolean validMove = game.makeMove(row, col);

        if (!validMove) {
            JOptionPane.showMessageDialog(
                    this, "Invalid move! Try another tile.");
            return;
        }

        updateDisplay();

        if (game.isGameOver()) {
            showResult();
        }
    }

    /**
     * Updates the GUI to match the board state.
     */
    public void updateDisplay() {

        TTTBoard board = game.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                char symbol = board.getTile(row, col);

                if (symbol == ' ') {
                    tiles[row][col].setText("");
                } else {
                    tiles[row][col].setText(String.valueOf(symbol));
                }
            }
        }

        if (!game.isGameOver()) {
            statusLabel.setText(
                    "Player " + game.getCurrentPlayer() + "'s turn");
        }
    }

    /**
     * Displays the winner or tie result.
     */
    public void showResult() {

        if (game.hasWinner()) {
            char winner = game.getCurrentPlayer();

            statusLabel.setText("Player " + winner + " wins!");

            JOptionPane.showMessageDialog(
                    this, "Player " + winner + " wins!");

        } else if (game.isTie()) {
            statusLabel.setText("It's a tie!");

            JOptionPane.showMessageDialog(
                    this, "It's a tie!");
        }
    }

    /**
     * Resets the game and clears all buttons.
     */
    private void restartGame() {
        game.restartGame();
        updateDisplay();
    }
}
