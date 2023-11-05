import java.util.List;

/**
 * Defines a player in the game
 *
 * @author rgill
 * @version 1.0
 */
public class Player {

    private String color;
    private List<Piece> pieces;

    public Player() {
        //Define logic for setting the color, and initializing chess pieces
    }

    // Shows which pieces a player has
    public List<Piece> hasPieces() {
        return pieces;
    }

    public String getColor() {
        return this.color;
    }

    public Boolean ownsPiece(Piece piece) {
        return false;
    }

    public List<Piece> initPieces(List<Piece> pieces) {
        return this.pieces = pieces;



































    }



}
