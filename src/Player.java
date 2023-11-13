import java.util.ArrayList;
import java.util.List;

/**
 * Defines a player in the game, and creates pieces for a player
 *
 * @author rgill
 * @version 1.0
 */
public class Player {

    /** The color of the players pieces */
    private String color;

    /** ArrayList to contain pieces for the player */
    private List<Piece> pieces = new ArrayList<>();

    /**
     * Sets the color for a player so all their pieces can match
     * the players color
     *
     * @param color color of the players pieces
     */
    public Player(String color) {
        this.color = color;

        // Initialize pieces when creating a new player
        initializePieces();
    }

    private void initializePieces() {
        // Initialize rooks, knights, bishops
        pieces.add(new Rook(color));
        pieces.add(new Knight(color));
        pieces.add(new Bishop(color));

        // Initialize the king and queen
        pieces.add(new Queen(color));
        pieces.add(new King(color));

        // Initialize the second rook, knight, bishop
        pieces.add(new Bishop(color));
        pieces.add(new Knight(color));
        pieces.add(new Rook(color));

        // Initialize pawns
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(color));
        }
    }


    /** Returns the pieces for a player */
    public List<Piece> getPieces() {
        return new ArrayList<>(pieces);
    }

    /**
     * Gets the piece color of the player
     * @return color of the players pieces
     */
    public String getColor() {
        return this.color;
    }

    /** Checks if a piece belongs to a player */
    public boolean ownsPiece(Piece piece) {
        return pieces.contains(piece);
    }
}
