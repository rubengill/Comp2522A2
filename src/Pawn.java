import java.util.List;

/**
 * Represents a pawn
 */
public class Pawn extends Piece {

    /**
     * Creates and sets the color for pawns
     * @param color color of the pawns
     */
    public Pawn(String color) {
        super(color);
    }

    /**
     * Gets the symbol for a pawn
     * @return symbol for a pawn
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♙" : "♟︎";

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
}