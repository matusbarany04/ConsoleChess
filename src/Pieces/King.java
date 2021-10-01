package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;
import Game.SquareState;

import java.util.ArrayList;
import java.util.Arrays;

public class King  extends Piece  {
    public char character = 'W';
    Point position;

    public King(Point position, PieceColor color){
        character = color.equals(PieceColor.BLACK) ? 'W' : 'w';
        this.position = position;
    }

    public void updatePos(Point newPos){
        position = newPos;
    }

    int[] x  = {+1,1,1,-1,-1,-1,0,0};
    int[] y =  {0,-1,+1,0,-1,1,+1,-1};
    @Override
    public Point[] getAllPossiblePositionsIn(Board board) {
        ArrayList<Point> positions = new ArrayList<>();
        for (int i = 0; i< x.length;i++){
            try {
                Point point = new Point(position.getX() + x[i], position.getY() + y[i]);
                if (board.getStateOf(point) != SquareState.INDEXOUT){
                    positions.add(point);
                }
            }catch (IndexOutOfBoundsException e){
            }
        }
        return positions.toArray(new Point[positions.size()]);
    }

    @Override
    public char getCharacter() {
        return character;
    }
}
