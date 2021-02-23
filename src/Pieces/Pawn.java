package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;
import Game.SquareState;

import java.util.ArrayList;

public class Pawn extends Piece {
    public  char character = 'P';
    Point position;
    boolean moved = false;
    PieceColor color;
    public Pawn(Point position, PieceColor color){
        this.color = color;
        character = color.equals(PieceColor.BLACK) ? 'P' : 'p';
        this.position = position;
    }

    public void updatePos(Point newPos) {
        position = newPos;
        moved = true;
    }


    @Override
    public Point[] getAllPossiblePositionsIn(Board board) {
        //return super.getAllPossiblePositionsIn(board);
        ArrayList<Point> positions = new ArrayList<>();
        int front = color.equals(PieceColor.BLACK) ? -1 : +1;

        Point one = new Point(position.getX(), position.getY() + front);
        if (board.getStateOf(one) == SquareState.EMPTY) {
            positions.add(one);

            Point two = new Point(position.getX(), position.getY() + front *2);
            if (!moved && board.getStateOf(two) == SquareState.EMPTY) {
                positions.add(two);
            }
        }

        Point oneLeft = new Point(position.getX() -1, position.getY() + front);
        if (board.getStateOf(oneLeft) == SquareState.PIECE) {
            positions.add(oneLeft);
        }

        Point oneRight = new Point(position.getX() +1, position.getY() + front);
        if (board.getStateOf(oneRight) == SquareState.PIECE) {
            positions.add(oneRight);
        }

        return positions.toArray(new Point[positions.size()]);
    }

    @Override
    public char getCharacter() {
        return character;
    }
}
