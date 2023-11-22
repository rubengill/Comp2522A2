import java.util.List;

/**
 * Represents a Bishop
 */
public class Bishop extends Piece {

    /**
     * Sets the color of the Rook
     * @param color color of the Rook
     */
    public Bishop(String color) {
        super(color);
    }

    /**
     * Checks if a path is valid
     *
     * @return true if move is valid
     */
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        return true;
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough(List<Tile> path) {
        return false;
    }

    /**
     * Returns the symbol of a rook
     * @return symbol of a rook
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♗" : "♝";

    }
}
