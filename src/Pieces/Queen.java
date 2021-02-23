package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen extends Piece  {

    public char character = 'Q';
    Point position;

    public Queen(Point position, PieceColor color) {
        character = color.equals(PieceColor.BLACK) ? 'Q' : 'q';
        this.position = position;
    }

    @Override
    public Point[] getAllPossiblePositionsIn(Board board){
        ArrayList<Point> positions = new ArrayList<>();

        positions.addAll(Arrays.asList(new Rock(position, PieceColor.BLACK).getAllPossiblePositionsIn(board)));
        positions.addAll(Arrays.asList(new Bishop(position, PieceColor.BLACK).getAllPossiblePositionsIn(board)));
        return positions.toArray(new Point[positions.size()]);
    }

    @Override
    public void updatePos(Point newPos){
        position = newPos;
    }

    @Override
    public char getCharacter() {
        return character;
    }

}
