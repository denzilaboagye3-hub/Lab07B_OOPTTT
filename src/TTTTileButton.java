
import javax.swing.*;
import java.awt.*;

/**
 * Custom Tic Tac Toe button that stores
 * its row and column position.
 */
public class TTTTileButton extends JButton {

    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;

        setFont(new Font("Arial", Font.BOLD, 60));
        setFocusPainted(false);
        setText("");
    }

    /**
     * Returns the button's row position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the button's column position.
     */
    public int getCol() {
        return col;
    }
}
