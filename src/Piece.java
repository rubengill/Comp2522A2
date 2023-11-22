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

    /** Tracks if the piece is in its initial position. */
    private boolean initialPosition;

    /**
     * Constructor that initializes a piece with a color
     * @param color color of the piece
     */
    public Piece(String color) {
        this.color = color;
        this.initialPosition = true;
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
    public abstract boolean isValidMove(int x1, int y1, int x2, int y2);

    /**
     * Checks if it can move through an obstructed path
     * @return true if it can move through a piece
     */
    public abstract boolean canMoveThrough(List<Tile> path);


    /**
     * Checks if the piece is in its initial position
     * @return true if it is in the initial position
     */
    public boolean isInitialPosition() {
        return initialPosition;
    }

    /**
     * Sets the position of the piece
     * @param initialPosition false if it is moved from the initial position
     */
    public void setInitialPosition(boolean initialPosition) {
        this.initialPosition = initialPosition;
    }

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
