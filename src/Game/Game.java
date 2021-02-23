package Game;

import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Game {

    Board gameBoard;
    Map<String, Integer> dictionary;

    public void start() throws IOException {
        gameBoard = new Board(8);

        gameBoard.renderToConsole();
        createDictionary();
        loop();
    }

    private void createDictionary() {
        String abc = "abcdefgh";
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < gameBoard.getBoardSize(); i++) {
            dictionary.put(String.valueOf(abc.charAt(i )), i);
        }
    }

    private int[] input(BufferedReader in) throws IOException {  //a1b3
        while (true) {
            String[] input = in.readLine().split("");
            int[] returnData = new int[4];
            if (input.length == 4) {
                try {
                    returnData[0] = dictionary.get(input[0]);
                    returnData[1] = Integer.parseInt(input[1]) -1;
                    returnData[2] = dictionary.get(input[2]);
                    returnData[3] = Integer.parseInt(input[3]) -1;
                    return returnData;
                } catch (NullPointerException e) {
                    System.out.println("WRONG INPUT!");
                }
            }else {
                System.out.println("WRONG INPUT TOO MANY CHARACTERS!");
            }
        }
    }

    private void processData(int[] move) {
        if (move.length == 4) { // check if data are correct length
            Point posOfPiece = new Point(move[0], move[1]);
            Point newPos = new Point(move[2], move[3]);

            Piece piece = gameBoard.getPieceAt(posOfPiece);

            if (piece != null) {

                Point[] allPossiblePositionsOfPiece = piece.getAllPossiblePositionsIn(gameBoard);

                boolean validMove = false;

                for (Point pos : allPossiblePositionsOfPiece) {
                    if (newPos.equals(pos)) {
                        gameBoard.movePiece(posOfPiece, newPos);
                        validMove = true;
                        break;
                    }
                }

                if (!validMove) {
                    System.out.println("BAD COORDINATES");
//                        for (Point pos : allPossiblePositionsOfPiece) {
//
//                            gameBoard.boardArray[pos.getX()][pos.getY()].setPiece();
//                        }
                }

            } else {
                System.out.println("INVALID INPUT");
            }
        } else {
            System.out.println("NO PIECE ON THAT SQUARE");
        }

    }

    public void loop() throws IOException {
        boolean winner = false;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (winner == false) {
            //get input
            int[] move = input(in);

            processData(move);
            //render the board
            gameBoard.renderToConsole();
        }
    }


}
