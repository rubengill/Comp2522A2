import java.util.List;

/**
 * Represents a Rook
 */
public class Rook extends Piece {

    /**
     * Creates and sets the color for a Rook
     * @param color color of the Rook
     */
    public Rook(String color) {
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
     * Gets the symbol of a Rook
     * @return the symbol of a Rook
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♖" : "♜";
    }
}
