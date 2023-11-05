import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Prints out the tile objects, assigning each alternating one a different color
 *
 * @author rgill
 * @version 1.0
 */
public class TileFrame extends JPanel {

    private static final Dimension TILE_SIZE = new Dimension(60, 60);
    private static final String WHITE_COLOR_STR = "WHITE";
    private static final String BLACK_COLOR_STR = "BLACK";
    private static final Color WHITE_COLOR_GUI = Color.WHITE;
    private static final Color BLACK_COLOR_GUI = Color.GRAY;

    private Tile tile;
    private boolean isSelected = false;
    private int row, col;  // Store row and col directly

    public TileFrame(int row, int col, Tile tile) {
        this.row = row;
        this.col = col;
        this.tile = tile;

        setPreferredSize(TILE_SIZE);
        setInitialBackgroundColor();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleSelection();
            }
        });
    }

    private void setInitialBackgroundColor() {
        if ((row + col) % 2 == 0) {
            this.tile.setColor(WHITE_COLOR_STR);
            setBackground(WHITE_COLOR_GUI);
        } else {
            this.tile.setColor(BLACK_COLOR_STR);
            setBackground(BLACK_COLOR_GUI);
        }
    }

    private void toggleSelection() {
        isSelected = !isSelected;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isSelected) {
            g.setColor(Color.GREEN);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);  // Draw a border around the entire tile
            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);  // Draw a second border inside to make it thicker
        }
    }

}
