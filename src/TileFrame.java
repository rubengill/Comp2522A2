import javax.swing.JPanel;
import java.awt.Color;

/** Displays a single tile for the chess game
 *
 * @author rgill
 * @version 1.o
 */
public class TileFrame extends JPanel{
    private static final Color WHITE_COLOR = Color.WHITE;
    private static final Color BLACK_COLOR = Color.GRAY;

    public static boolean white = true;

    public TileFrame() {
        setBackground(white ? WHITE_COLOR: BLACK_COLOR);
        // Done to alternate tile color
        white = !white;
    }
}
