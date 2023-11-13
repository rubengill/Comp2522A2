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
    public boolean isValidMove(List<Tile> path) {
        return true;
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough() {
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
