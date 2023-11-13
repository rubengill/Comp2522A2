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
    private BoardFrame boardFrame;

    /**
     * Creates a TileFrame, which will create a BoardFrame object
     *
     * @param row the row
     * @param col the col
     * @param tile the tile at the position
     * @param boardFrame the BoardFrame for the tiles
     */
    public TileFrame(int row, int col, Tile tile, BoardFrame boardFrame) {
        this.tile = tile;
        this.boardFrame = boardFrame;

        setPreferredSize(TILE_SIZE);
        setInitialBackgroundColor(row, col);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boardFrame.selectTileFrame(TileFrame.this);
            }
        });
    }

    /**
     * Set the background color for the tiles
     * @param row the row
     * @param col the col
     */
    private void setInitialBackgroundColor(int row, int col) {
        if ((row + col) % 2 == 0) {
            setBackground(WHITE_COLOR_GUI);
        } else {
            setBackground(BLACK_COLOR_GUI);
        }
    }

    /**
     * Checks if a tile is selected
     *
     * @param selected true if a tile is not selected
     */
    public void setSelected(boolean selected) {
        if (this.isSelected != selected) {
            this.isSelected = selected;
            repaint();
        }
    }

    /**
     * Sets the Pieces to be fully either black or white
     * for added clarity
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable anti-aliasing for smoother text
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw the selection highlight if the tile is selected
        if (isSelected) {
            g2d.setColor(Color.GREEN);
            g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g2d.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        }

        if (tile.getPiece() != null) {
            // Set the font larger
            g2d.setFont(new Font("Default", Font.BOLD, 24));

            // Get the piece representation
            String representation = tile.getPiece().getRepresentation();
            FontMetrics metrics = g2d.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth(representation)) / 2;
            int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

            // Determine the color of the piece and draw
            if (tile.getPiece().getColor().equals("white")) {
                // Draw the black outline
                g2d.setColor(Color.BLACK);
                g2d.drawString(representation, x + 1, y + 1);
                // Draw the white pawn
                g2d.setColor(Color.WHITE);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString(representation, x, y);
        }
        g2d.dispose();
    }

    /**
     * Gets the tile
     * @return the tile
     */
    public Tile getTile() {
        return tile;
    }
}
