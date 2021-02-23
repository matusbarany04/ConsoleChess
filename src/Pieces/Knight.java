package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;

import java.util.ArrayList;

public class Knight extends Piece  {

    public char character = 'K';
    Point position;

    public Knight(Point position, PieceColor color) {
        character = color.equals(PieceColor.BLACK) ? 'K' : 'k';
        this.position = position;
    }




    int[] x = {-1,+1,-1,+1,+2,+2,-2,-2};
    int[] y = {-2,-2,+2,+2,+1,-1,+1,-1};
    @Override
    public Point[] getAllPossiblePositionsIn(Board board) {
        ArrayList<Point> positions = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Point move = new Point(position.getX() + x[i], position.getY() + y[i]);
                boolean valid = board.isValid(move);
            if (valid){
                positions.add(move);
            }
        }

        return positions.toArray(new Point[positions.size()]);
    }



    public void updatePos(Point newPos){
        position = newPos;
    }

    @Override
    public char getCharacter() {
        return character;
    }

}
