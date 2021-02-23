package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;
import Game.SquareState;

import java.util.ArrayList;

public class Rock extends Piece {
    public char character  = 'R';
    Point position;

    public Rock(Point position, PieceColor color) {
        character = color.equals(PieceColor.BLACK) ? 'R' : 'r';
        this.position = position;
    }


    @Override
    public Point[] getAllPossiblePositionsIn(Board board) {
        ArrayList<Point> positions = new ArrayList<>();
        //for horizontal squares
        for (int x = position.getX() + 1; x < board.boardArray[1].length; x += 1) {
            char ch = board.boardArray[x][position.getY()].getSquare();
            if (ch == board.blackChar || ch == board.whiteChar) {
                positions.add(new Point(x, position.getY()));
            } else {
                positions.add(new Point(x, position.getY()));
                break;
            }
        }
        for (int x = position.getX() - 1; x >= 0; x += -1) {
            char ch = board.boardArray[x][position.getY()].getSquare();
            if (ch == board.blackChar || ch == board.whiteChar) {
                positions.add(new Point(x, position.getY()));
            } else {
                positions.add(new Point(x, position.getY()));
                break;
            }
        }

        //for vertical squares
        for (int y = position.getY() - 1; y >= 0; y += -1) {
            char ch = board.boardArray[position.getX()][y].getSquare();
            if (ch == board.blackChar || ch == board.whiteChar) {
                positions.add(new Point(position.getX(), y));
            } else {
                positions.add(new Point(position.getX(), y));
                break;
            }
        }

        for (int y = position.getY() + 1; y < board.boardArray.length; y += 1) {
            char ch = board.boardArray[position.getX()][y].getSquare();
            if (board.getStateOf(new Point(position.getX(), y)) == SquareState.EMPTY) {
                positions.add(new Point(position.getX(), y));
            } else {
                positions.add(new Point(position.getX(), y));
                break;
            }
        }


        return positions.toArray(new Point[positions.size()]);
    }

    @Override
    public void updatePos(Point newPos) {
        position = newPos;
    }

    @Override
    public char getCharacter() {
        return character;
    }
}

