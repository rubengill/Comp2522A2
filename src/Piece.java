import java.util.List;

/**
 * Superclass for all the chess pieces
 *
 * @author rgill
 * @version 1.0
 */
public abstract class Piece {

    /** The color of the piece */
    protected String color;

    /**
     * Constructor that initializes a piece with a color
     * @param color color of the piece
     */
    public Piece(String color) {
        this.color = color;
    }

    /**
     * Checks if a path is valid
     * @return true if move is valid
     */
    public abstract boolean isValidMove(List<Tile> path);

    /**
     * Checks if it can move through an obstructed path
     * @return true if it can move through a piece
     */
    public abstract boolean canMoveThrough();

    /**
     * Gets the color of the piece
     * @return the color of the piece
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Sets the color of the piece
     * @param color color of the piece
     * @return color of the piece
     */
    public String setColor(String color) {
        return this.color = color;
    }

    /**
     * The symbol of a piece
     * @return symbol of a piece
     */
    public abstract String getRepresentation();

}
