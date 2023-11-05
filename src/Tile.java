/**
 * Represents a space on the board that a piece can occupy
 *
 * @author rgill
 * @version 1.0
 */
public class Tile {

    /** Color of the tile */
    private String color;

    /** Piece on the tile */
    private Piece piece;

    /**
     * Instantiates Tile objects
    public Tile() {
        // Default values
        this.color = null;
        this.piece = null;
    }

    /**
     * Get the color of the tile
     * @return color of the tile
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the tile
     * @param color color of the Tile
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Piece on the tile
     * @return piece on the tile
     */
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}



