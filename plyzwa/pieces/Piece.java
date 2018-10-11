package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;
import com.plyzwa.board.BoardFunc;
import com.plyzwa.board.Square;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Piece {

    protected final int xPos, yPos;
    protected final Color myColor;
    protected int[][] MOVES;

    public Piece(int xPos, int yPos, Color myColor) {
        System.out.println(this.getClass() + " Constructor");
        this.xPos = xPos;
        this.yPos = yPos;
        this.myColor = myColor;
        this.MOVES = this.makeArray();
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Color getMyColor() {
        return myColor;
    }

    public Collection<Move> movesSet(Board board) {

        int xDestCandidate, yDestCandidate;
        Set<Move> legalMoves = new HashSet<>();

        for (final int curentSet[] : this.MOVES) {
            xDestCandidate = this.xPos + curentSet[0];
            yDestCandidate = this.yPos + curentSet[1];

            if ( BoardFunc.isOnThePlane(xDestCandidate, yDestCandidate)) {
                final Square candidate = board.getSquare(xDestCandidate, yDestCandidate);
                if (!this.isAnythingOnThePath(board)) {
                    if (candidate.isEmpty()) {
                        legalMoves.add(new MajorMove(board, this, xDestCandidate, yDestCandidate));
                    } else {
                        final Piece pieceInDestination = candidate.getPiece();
                        final Color pieceColor = pieceInDestination.getMyColor();
                        if (this.getMyColor() != pieceColor) {
                            legalMoves.add(new AttackMove(board, this, xDestCandidate,
                                    yDestCandidate, pieceInDestination));
                        }
                    }
                }

            }

        }
        return Collections.unmodifiableSet(legalMoves);
    }
    //This need to be implemented in further work
    public abstract boolean isAnythingOnThePath(Board board);

    /**
     * This method makes an array of all possible moves of certain Piece.
     * @return array of all possible moves.
     */
    protected abstract int[][] makeArray();


}
