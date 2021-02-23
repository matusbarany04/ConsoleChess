package Game;

import Pieces.Piece;
import org.jetbrains.annotations.Nullable;

public class Box {

    Piece piece = null;
    char defaultSquare;


    public Box(@Nullable Piece piece, char defaultSquare) {
        this.piece = piece;
        this.defaultSquare = defaultSquare;
    }

    public boolean isValid(){
        return true;
    }

    public char getSquare() {
        if (piece != null) {
            return piece.getCharacter();
        } else {
            return defaultSquare;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
