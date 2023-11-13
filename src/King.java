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
     * Sets the symbol for the King
     * @return symbol for the King
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♔" : "♚";
    }
}
