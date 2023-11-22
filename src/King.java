import java.util.List;

/**
 * Represents a King piece
 */
public class King extends Piece {

    /**
     * Creates a piece and sets the color of it
     * @param color color of the King
     */
    public King(String color) {
        super(color);
    }

    /**
     * Validates a move
     *
     * @param x1 x1 coordinate
     * @param y1 y1 coordinate
     * @param x2 x2 coordinate
     * @param y2 y2 coordinate
     * @return
     */
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Calculate the difference in rows and columns
        int rowDiff = Math.abs(x2 - x1);
        int colDiff = Math.abs(y2 - y1);

        // Check if the King moves only one square in any direction
        return (rowDiff <= 1 && colDiff <= 1);
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough(List<Tile> path) {
        return true;
    }

    /**
     * Sets the symbol for the King
     * @return symbol for the King
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♔" : "♚";
    }
}
