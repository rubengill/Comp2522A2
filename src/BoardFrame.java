import javax.swing.*;
import java.awt.*;
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
    private Game game;

    /**
     * Sets up the Board based to be displayed
     *
     * @param board the board
     */
    public BoardFrame(Board board, Game game) {
        this.game = game;
        this.board = board;
        int size = board.getSize();
        setLayout(new GridLayout(size, size));
        tileFrames = new TileFrame[size][size];
        System.out.println("Game: " + game + ",BoardFrame: " + board + ",Game Board: " + game.getBoard());
        populateBoard();
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

    /** Selects a tile */
    public void selectTileFrame(TileFrame tileFrame) {
        game.handleTileSelection(tileFrame);
    }

    /**
     * Sets the pieces in the correct position
     * @param players the pieces for the players
     */
    public void initializeBoard(List<Player> players) {
        for (Player player : players) {
            List<Piece> pieces = player.getPieces();
            String color = player.getColor();

            // pawn starting row
            int pawnRow = color.equals("white") ? 7 : 0;
            // other pieces starting row
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
                placePiece(pieces.get(14), backRow, 3);
                placePiece(pieces.get(15), backRow, 4);
            } else {
                placePiece(pieces.get(14), backRow, 4);
                placePiece(pieces.get(15), backRow, 3);
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
}

