package Game;

import Pieces.*;

import java.io.StringReader;

public class Board {

    public Box[][] boardArray;
    int boardSize = 8;
    public final char blackChar = '-'; // ◻ ◻ □
    public final char whiteChar = '*'; // ■

    public Board(int boardSize) {
        this.boardSize = boardSize;
        boardArray = new Box[boardSize][boardSize];
        makeNewBoard();
    }

    public boolean isValid(Point square){
        boolean valid;
        try {
            valid = boardArray[square.getX()][square.getY()].isValid();
        }catch (IndexOutOfBoundsException e){
            valid = false;
        }
        return valid;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void makeNewBoard() {
        boolean squareColor = false;

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                boardArray[x][y] = new Box(null, squareColor ? whiteChar : blackChar);
                squareColor = !squareColor;
            }
            squareColor = !squareColor;
        }
        addPieces(PieceColor.BLACK);
        addPieces(PieceColor.WHITE);
    }

    public Piece getPieceAt(Point pos){
       return boardArray[pos.getX()][pos.getY()].getPiece();
    }

    public void renderToConsole() {
        System.out.println("  | a | b | c | d | e | f | g | h |");
        System.out.println("  ---------------------------------");
        for (int x = 0; x < boardSize; x++) {
            System.out.print(x +1  + " ");
            for (int y = 0; y < boardSize; y++) {
                System.out.print("| " + boardArray[y][x].getSquare() + " ");
            }
            System.out.println("|");
        }
        System.out.println("  ---------------------------------");
        System.out.println("  | a | b | c | d | e | f | g | h |");
    }

    public boolean movePiece(Point piecePos, Point newPos){
        Piece piece = boardArray[piecePos.getX()][piecePos.getY()].getPiece();
        if (piece != null) {
            boardArray[piecePos.getX()][piecePos.getY()].setPiece(null); ;
            boardArray[newPos.getX()][newPos.getY()].setPiece(piece);
            piece.updatePos(newPos);
            return true;
        }else {
            return false;
        }
    }

    public SquareState getStateOf(Point square){
        try{
            char ch = boardArray[square.getX()][square.getY()].getSquare();
            return ch == blackChar || ch == whiteChar ? SquareState.EMPTY: SquareState.PIECE;

        }catch (IndexOutOfBoundsException e){
            return SquareState.INDEXOUT;
        }
    }


    public Piece[] addPieces(PieceColor color) {
        int y = color.equals(color.BLACK) ? 7 : 0;
        int front = color.equals(color.BLACK) ? -1 : +1;
          Piece[] pieces = new Piece[16];
        boardArray[0][y].setPiece(new Rock(new Point(0,y), color));
        boardArray[1][y].setPiece(new Knight(new Point(1,y), color));
        boardArray[2][y].setPiece(new Bishop(new Point(2,y), color));
        boardArray[3][y].setPiece(new King(new Point(3,y), color));
        boardArray[4][y].setPiece(new Queen(new Point(4,y), color));
        boardArray[5][y].setPiece(new Bishop(new Point(5,y), color));
        boardArray[6][y].setPiece(new Knight(new Point(6,y), color));
        boardArray[7][y].setPiece( new Rock(new Point(7,y), color));

        for (int x = 0; x < boardSize;x++){
            boardArray[x][y  + front].setPiece(new Pawn(new Point(x,y+ front), color));
        }

//        boardArray[0][0].setPiece(new Rock(new Point(0,7)));
//        boardArray[1][0].setPiece(new Knight(new Point(1,7)));
//        boardArray[2][0].setPiece(new Bishop(new Point(2,7)));
//        boardArray[3][0].setPiece(new King(new Point(3,7)));
//        boardArray[4][0].setPiece(new Queen(new Point(4,7)));
//        boardArray[5][0].setPiece(new Bishop(new Point(5,7)));
//        boardArray[6][0].setPiece(new Knight(new Point(6,7)));
//        boardArray[7][0].setPiece( new Rock(new Point(7,7)));
//
//        for (int x = 0; x < boardSize;x++){
//            boardArray[x][1].setPiece( new Pawn(new Point(x,6)));
//        }
        //boardArray[3][4].setPiece(new Bishop(new Point(3,4)));

        return pieces;
    }
}
