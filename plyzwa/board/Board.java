package com.plyzwa.board;

import com.plyzwa.Color;
import com.plyzwa.Player;
import com.plyzwa.pieces.*;

import java.util.*;

public class Board {

    private final List<Square> gameBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;

    private final Player blackPlayer;
    private final Player whitePlayer;

    private Board(Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = activePiecesOnThePlane(this.gameBoard, Color.WHITE);
        this.blackPieces = activePiecesOnThePlane(this.gameBoard, Color.BLACK);

//        Collection<Move> whiteMoves = calculateMoves(this.whitePieces);
//        Collection<Move> blackPieces = calculateMoves(this.blackPieces);
    }
    //This method need improvement
//    private Collection<Move> calculateMoves(Collection<Piece> pieces) {
//        List<Move> legalMoves = new ArrayList<>(pieces);
//        for (Piece piece : pieces ) {
//            legalMoves.add(piece.movesSet(this));
//        }
//        return null;
//    }

    private Collection<Piece> activePiecesOnThePlane(List<Square> gameBoard, Color color) {
        final List<Piece> activeOnes = new ArrayList<>();
        for (Square square : gameBoard) {
            if (!square.isEmpty()) {
                Piece piece = square.getPiece();
                if (piece.getMyColor() == color) {
                    activeOnes.add(piece);
                }
            }
        }
        return activeOnes;
    }

    private static List<Square> createGameBoard(Builder builder) {
        final Square[] squares = new Square[64];
        String tmp;
        LinkedList<Square> myList = new LinkedList<>();
        int incr=0;
        for (int i=1;i<=8;i++) {
            for (int j=1;j<=8;j++) {
                tmp = "X"+i+"Y"+j;
                squares[incr] = Square.createSquare(i, j, builder.boardConfig.get(tmp));
                myList.add(squares[incr++]);
            }
        }
        return Collections.unmodifiableList(myList);
    }
    //This method have to be improved!!!!!!!!
    public Square getSquare(int xCord, int yCord) {
        return this.gameBoard.get(yCord+8*(xCord-1));
    }
    public static Board CrateInitialBoard() {
        Builder builder = new Builder();
        builder.setPiece(new Tower(1,1, Color.WHITE));
        builder.setPiece(new Tower(8,1, Color.WHITE));
        builder.setPiece(new Tower(1,8, Color.BLACK));
        builder.setPiece(new Tower(8,8, Color.BLACK));

        builder.setPiece(new Knight(2,1,Color.WHITE));
        builder.setPiece(new Knight(7,1,Color.WHITE));
        builder.setPiece(new Knight(2,8,Color.BLACK));
        builder.setPiece(new Knight(7,8,Color.BLACK));

        builder.setPiece(new Bishop(3,1,Color.WHITE));
        builder.setPiece(new Bishop(6,1,Color.WHITE));
        builder.setPiece(new Bishop(3,8,Color.BLACK));
        builder.setPiece(new Bishop(6,8,Color.BLACK));

        builder.setPiece(new Queen(4, 1, Color.WHITE));
        builder.setPiece(new Queen(4, 8, Color.BLACK));

        builder.setPiece(new King(5, 1, Color.WHITE));
        builder.setPiece(new King(5, 8, Color.BLACK));

        for (int i=1;i<=8;i++) {
            builder.setPiece(new Pawn(i, 2, Color.WHITE));
            builder.setPiece(new Pawn(i, 7, Color.BLACK));
        }
        builder.setNextMove(Color.WHITE);
        return builder.build();

    }


    public static class Builder {
        Map<String, Piece> boardConfig;
        Color whoIsNext;

        public Builder() {
            this.boardConfig = new HashMap<>();
        }
        public Builder setPiece(Piece piece) {
            String tmp = "X"+piece.getxPos()+"Y"+piece.getyPos();
            this.boardConfig.put(tmp, piece);
            return this;
        }
        public Builder setNextMove(Color nextColor) {
            this.whoIsNext = nextColor;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
