/**
 * Superclass for all the chess pieces
 *
 * @author rgill
 * @version 1.0
 */
public abstract class Piece {

    protected String color;

    public Piece() {
        this.color = color;
    }

    /**
     * Checks if a path is valid
     * @return true if move is valid
     */
    public abstract boolean isValidMove();

    /**
     * Checks if it can move through an obstructed path
     * @return true if it can move through a piece
     */
    public abstract boolean canMoveThrough();

    // Getter for color
    public String getColor() {
        return this.color;
    }

    // Sets color
    public String setColor(String color) {
        return this.color = color;
    }
}
