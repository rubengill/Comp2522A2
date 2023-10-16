import javax.swing.*;
import java.awt.*;

/** Displays the board for the chess game
 *
 * @author rgill
 * @version 1.o
 */
public class BoardFrame extends JPanel {
    private final int BOARD_SIZE;

    /**
     * Initializes the board with alternating colored tiles
     *
     * @param size size of the board
     */
    public BoardFrame(int size) {
        this.BOARD_SIZE = size;

        // Set the layout to a grid based on BOARD_SIZE
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        // Loop through each position on the board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // Create a new TileFrame for each position and add it to the board
                TileFrame tileFrame = new TileFrame(i, j);
                add(tileFrame);
            }
        }
    }
}
