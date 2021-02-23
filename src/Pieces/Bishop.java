package Pieces;

import Game.Board;
import Game.PieceColor;
import Game.Point;
import Game.SquareState;

import java.util.ArrayList;

public class Bishop extends Piece {

    public char character = 'B';
    Point position;

    public Bishop(Point position, PieceColor color) {
        character = color.equals(PieceColor.BLACK) ? 'B' : 'b';
        this.position = position;
    }


    @Override
    public Point[] getAllPossiblePositionsIn(Board board) {
        ArrayList<Point> positions = new ArrayList<>();
        //right down
        int y = position.getY() + 1;
        for (int x = position.getX() + 1; x < board.getBoardSize() && y < board.getBoardSize(); x++) {
            try {
                Point point = new Point(x, y);
                if (board.getStateOf(point) == SquareState.EMPTY) {
                    positions.add(point);
                    y++;
                } else {
                    positions.add(point);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //right up
        y = position.getY() -1;
        for (int x = position.getX() + 1; x < board.getBoardSize() && y >= 0; x++) {
            try {
                Point point = new Point(x, y);
                if (board.getStateOf(point) == SquareState.EMPTY) {
                    positions.add(point);
                    y--;
                } else {
                    positions.add(point);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //left up
        y = position.getY() -1;
        for (int x = position.getX() -1; x >= 0 && y >= 0; x--) {
            try {
                Point point = new Point(x, y);
                if (board.getStateOf(point) == SquareState.EMPTY) {
                    positions.add(point);
                    y--;
                } else {
                    positions.add(point);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //left down
        y = position.getY() + 1;
        for (int x = position.getX() - 1; x >= 0 && y < board.getBoardSize(); x--) {
            try {
                Point point = new Point(x, y);
                if (board.getStateOf(point) == SquareState.EMPTY) {
                    positions.add(point);
                    y++;
                } else {
                    positions.add(point);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return positions.toArray(new Point[positions.size()]);
    }

    public void updatePos(Point newPos) {
        position = newPos;
    }

    @Override
    public char getCharacter() {
        return character;
    }
}
