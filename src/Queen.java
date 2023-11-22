import java.util.List;

/**
 * Represents a Queen
 */
public class Queen extends Piece {

    /**
     * Creates a Queen object and sets the color
     * @param color color of the queen object
     */
    public Queen(String color) {
        super(color);
    }

    /**
     * Validates a move
     *
     * @param x1 x1 coordinate
     * @param y1 y1 coordinate
     * @param x2 x2 coordinate
     * @param y2 y2 coordinate
     * @return true if the move is valid
     */
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check for horizontal movement (same row)
        if (x1 == x2 && y1 != y2) {
            return true;
        }
        // Check for vertical movement (same column)
        if (y1 == y2 && x1 != x2) {
            return true;
        }
        // Check for diagonal movement
        return Math.abs(x2 - x1) == Math.abs(y2 - y1);
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough(List<Tile> path) {
        for (Tile tile : path) {
            if (tile.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the symbol of a Queen
     * @return symbol of a Queen
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♕" : "♛";
    }
}
