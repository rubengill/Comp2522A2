import java.util.List;

/**
 * Represents a Knight
 */
public class Knight extends Piece {

    /**
     * Creates and sets the color for a Knight
     * @param color the color of the knight
     */
    public Knight(String color) {
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
        int xDiff = Math.abs(x2 - x1);
        int yDiff = Math.abs(y2 - y1);

        // Check for L-shaped movement
        return (xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2);
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
     * Gets the symbol for the Knight
     * @return the symbol for the knight
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♘" : "♞";
    }
}
