import javax.swing.*;
import java.awt.*;

/** Displays the board for the chess game
 *
 * @author rgill
 * @version 1.0
 */
public class BoardFrame extends JPanel {
    private Board board;

    public BoardFrame(Board board) {
        this.board = board;

        int size = board.getSize();

        // Set the layout to a grid based on board size
        setLayout(new GridLayout(size, size));

        // Loop through each position on the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Gets the tile position
                Tile tile = board.getTile(i, j);
                // Modified TileFrame constructor to receive a Tile object
                TileFrame tileFrame = new TileFrame(i, j, tile);
                add(tileFrame);
            }
        }
    }
}
