
import javax.swing.SwingUtilities;

/**
 * Launches the OOP Tic Tac Toe application.
 */
public class TTTRunner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TTTGameGUI gui = new TTTGameGUI();
            gui.setVisible(true);
        });
    }
}
