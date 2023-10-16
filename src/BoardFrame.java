import javax.swing.*;
import java.awt.*;

/** Displays the board for the chess game
 *
 * @author rgill
 * @version 1.o
 */
public class BoardFrame extends JPanel {
    private final int BOARD_SIZE;

    public BoardFrame(int size) {
        this.BOARD_SIZE = size;

        // Set border to board size
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        // loop to add tiles
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++) {
                TileFrame titleFrame = new TileFrame();
            }
    }
}
