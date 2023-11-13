import java.util.ArrayList;
import java.util.List;

/**
 * Represents the entire game space, pieces may not occupy
 * positions that are not within the board. Board is compromised
 * of Tile objects
 *
 * @author rgill
 * @version 1.0
 */
public class Board {

    /** 2D array of tiles, which together make up a board */
    private Tile[][] tiles;

    /** Tile to move too */
    private Tile destinationTile;

    /** Starting Tile */
    private Tile startTile;

    /** Piece to move */
    private Piece selectedPiece;

    /**
     * Instantiate an 8 * 8 board object
     */
    public Board() {
        // Creates 8 * 8 array of null values
        tiles = new Tile[8][8];

        //Instantiate each element in the array
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    /**
     * Instantiate a board with desired width and length
     * @param width width of the board
     * @param height height of the board
     */
    public Board(int width, int height) {
        this.tiles = new Tile[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Initialize each tile
                tiles[i][j] = new Tile();
            }
        }
    }

    /**
     * Set startTile
     * @param tile tile to move too
     */
    public void setStartTile(Tile tile) {
        this.startTile = tile;
    }

    /**
     * Returns the startTile
     * @return returns the startTile
     */
    public Tile getStartTile() {
        return this.startTile;
    }

    /**
     * Set destinationTile
     * @param tile tile to move too
     */
    public void setDestinationTile(Tile tile) {
        this.destinationTile = tile;
    }

    /**
     * Returns the destinationTile
     * @return returns the destinationTile
     */
    public Tile getDestinationTile() {
        return this.destinationTile;
    }

    /**
     * Select the piece to move
     * @param piece piece to be moved
     */
    public void setSelectedPiece(Piece piece) {
        this.selectedPiece = piece;
    }

    /**
     * Returns the selectedPiece
     * @return returns the selectedPiece
     */
    public Piece getSelectedPiece() {
        return this.selectedPiece;
    }

    /**
     * Returns the size of the game board
     * @return number of tiles in the game board
     */
    public int getSize() {
        return tiles.length;
    }

    /**
     * Gets tile at a selected position
     * @param x tile x axis position
     * @param y tile y axis position
     * @return tile at x, y position
     */
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    /**
     * Determines the path the piece wants to move
     * @param startTile starting tile
     * @param endTile end tile
     * @return the path the piece wants to move
     */
    public List<Tile> getPath(Tile startTile, Tile endTile) {
        List<Tile> path = new ArrayList<>();
        path.add(startTile);
        path.add(endTile);
        return path;
    }

    /**
     * Moves a piece if the move is valid
     * @param endTile the end tile
     */
    public void movePiece(Tile endTile) {
        if (this.startTile != null && this.selectedPiece != null) {
            List<Tile> path = getPath(this.startTile, endTile);
            if (selectedPiece.isValidMove(getPath(startTile, endTile))) {
                endTile.setPiece(this.selectedPiece); // Move the piece
                this.startTile.setPiece(null);       // Remove the piece from the start tile
            }
        }
        // Reset startTile and selectedPiece after the move
        this.startTile = null;
        this.selectedPiece = null;
    }
}

