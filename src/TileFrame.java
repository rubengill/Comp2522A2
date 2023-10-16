import javax.swing.JPanel;
import java.awt.*;

/** Displays a single tile for the chess game
 *
 * @author rgill
 * @version 1.o
 */
public class TileFrame extends JPanel {
    // Define the size of each tile
    private static final Dimension TILE_SIZE = new Dimension(60, 60);
    private static final Color WHITE_COLOR = Color.WHITE;
    private static final Color BLACK_COLOR = Color.GRAY;

    /**
     * Determines the background color based on the row and column provided
     *
     * @param row Row index of the tile
     * @param col Column index of the tile
     */
    public TileFrame(int row, int col) {
        setPreferredSize(TILE_SIZE);
        // Set background color based on row and col indices
        if ((row + col) % 2 == 0) {
            setBackground(WHITE_COLOR);
        } else {
            setBackground(BLACK_COLOR);
        }
    }
}
