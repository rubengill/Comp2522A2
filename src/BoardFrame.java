import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/** Displays the board for the chess game
 *
 * @author rgill
 * @version 1.0
 */
public class BoardFrame extends JPanel {
    private Board board;
    private TileFrame selectedTileFrame;
    private TileFrame[][] tileFrames;

    /**
     * Sets up the Board based to be displayed
     *
     * @param board the board
     * @param players the players in the game
     */
    public BoardFrame(Board board, List<Player> players) {
        this.board = board;
        int size = board.getSize();
        setLayout(new GridLayout(size, size));
        tileFrames = new TileFrame[size][size];
        populateBoard();
        initializeBoard(players);
    }

    /**
     * Files the Board with TileFrames
     */
    private void populateBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Tile tile = board.getTile(i, j);
                TileFrame tileFrame = new TileFrame(i, j, tile, this);
                // Store the TileFrame
                tileFrames[i][j] = tileFrame;
                add(tileFrame);
            }
        }
    }

    /**
     * Moves a piece if valid
     * @param tileFrame the tile selected
     */
    public void selectTileFrame(TileFrame tileFrame) {
        if (selectedTileFrame != null) {
            // Selecting the destination tile
            if (selectedTileFrame == tileFrame) {
                // The same tile was clicked twice, ignore
                return;
            }
            Tile startTile = selectedTileFrame.getTile();
            Tile endTile = tileFrame.getTile();

            if(startTile.isOccupied()) {
                // Set start and destination tiles and the selected piece on the board
                board.setStartTile(startTile);
                board.setDestinationTile(endTile);
                board.setSelectedPiece(startTile.getPiece());

                // Then attempt to move the piece.
                board.movePiece(endTile);

                selectedTileFrame.setSelected(false);
                tileFrame.setSelected(false);
                selectedTileFrame.repaint();
                tileFrame.repaint();
                selectedTileFrame = null;
            }
        } else {
            selectedTileFrame = tileFrame;
            // Mark the tile as selected
            selectedTileFrame.setSelected(true);
            selectedTileFrame.repaint();
        }
    }

    /**
     * Sets the pieces in the correct position
     * @param players the pieces for the players
     */
    public void initializeBoard(List<Player> players) {
        for (Player player : players) {
            List<Piece> pieces = player.getPieces();
            String color = player.getColor();

            // pawns' starting row
            int pawnRow = color.equals("white") ? 7 : 0;
            // other pieces' starting row
            int backRow = color.equals("white") ? 6 : 1;

            // Place pawns
            for (int i = 0; i < board.getSize(); i++) {
                placePiece(pieces.get(i), pawnRow, i);
            }

            // Place rooks
            placePiece(pieces.get(8), backRow, 0);
            placePiece(pieces.get(9), backRow, 7);

            // Place knights
            placePiece(pieces.get(10), backRow, 1);
            placePiece(pieces.get(11), backRow, 6);

            // Place bishops
            placePiece(pieces.get(12), backRow, 2);
            placePiece(pieces.get(13), backRow, 5);

            // Place queen and king
            if (color.equals("white")) {
                placePiece(pieces.get(14), backRow, 3); // Queen
                placePiece(pieces.get(15), backRow, 4); // King
            } else {
                placePiece(pieces.get(14), backRow, 4); // Queen
                placePiece(pieces.get(15), backRow, 3); // King
            }
        }
    }

    /**
     * Sets the piece in a specific position
     *
     * @param piece Piece to set
     * @param row row number
     * @param col column number
     */
    private void placePiece(Piece piece, int row, int col) {
        Tile tile = board.getTile(row, col);
        tile.setPiece(piece);
    }

    /**
     * Getter for the TileFrame
     * @param row the row
     * @param col the col
     * @return the TileFrame at a specific position
     */
    private TileFrame getTileFrame(int row, int col) {
        return tileFrames[row][col];
    }
}

