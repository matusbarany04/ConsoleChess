package Pieces;

import Game.Board;
import Game.Point;

public abstract class Piece implements Cloneable {
    char character = 'X';
    Point position;

    public Point[] getAllPossiblePositionsIn(Board board){
        return null;
    }

    public void updatePos(Point newPos){
        position = newPos;
    }


    public boolean isALive(){
        return true;
    }
    public char getCharacter() {
        return character;
    }
}
