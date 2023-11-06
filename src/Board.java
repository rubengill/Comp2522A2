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

    private List<Tile> getPath(Piece piece, Tile startTile, Tile endTile) {

        return null;
    }

}

