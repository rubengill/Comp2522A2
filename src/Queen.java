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
     * Gets the symbol of a Queen
     * @return symbol of a Queen
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♕" : "♛";
    }
}
