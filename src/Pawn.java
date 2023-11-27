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
     * Validates a move
     *
     * @param x1 x1 coordinate
     * @param y1 y1 coordinate
     * @param x2 x2 coordinate
     * @param y2 y2 coordinate
     * @return true if the move is valid
     */
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        int verticalDistance = x2 - x1;
        int horizontalDistance = y2 - y1;

        if (horizontalDistance == 0) {
            // White pawns move 'up' the board
            if (this.color.equals("white")) {
                // Check for the first move
                if (isInitialPosition()) {
                    if (verticalDistance == -2 || verticalDistance == -1) {
                        setInitialPosition(false);
                        return true;
                    }
                }
                // Regular move is 1 square
                else return verticalDistance == -1;
            }
            // Black pawns move 'down' the board
            else if (this.color.equals("black")) {
                // Check for the first move
                if (isInitialPosition()) {
                    if (verticalDistance == 2 || verticalDistance == 1) {
                        setInitialPosition(false);
                        return true;
                    }
                }
                // Regular move is 1 square
                else return verticalDistance == 1;
            }
        }
        return false;
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @param path the path the piece wants to move
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough(List<Tile> path) {
        for (Tile tile : path) {
            if (tile.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the symbol for a pawn
     * @return symbol for a pawn
     */
    @Override
    public String getRepresentation() {
        return color.equals("white") ? "♙" : "♟︎";
    }
}
