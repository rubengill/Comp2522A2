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
     * Gets the symbol for the Knight
     * @return the symbol for the knight
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♘" : "♞";

    }
}
