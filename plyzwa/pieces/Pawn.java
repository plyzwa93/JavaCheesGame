package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;
import com.plyzwa.board.BoardFunc;
import com.plyzwa.board.Square;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Pawn extends Piece {
    public Pawn(int xPos, int ypos, Color myColor) {
        super(xPos, ypos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = {{-1, 1}, {0, 1}, {1, 1} };
        return tmp;
    }

    /**
     * Method mmoveSet have to be overriden due to the different moves of pawn if there is the piece
     * on certain position.
     * @param board actual state of the plane is passed to the method.
     * @return moveset array
     */
    @Override
    public Collection<Move> movesSet(Board board) {

        int xDestCandidate, yDestCandidate;
        Set<Move> legalMoves = new HashSet<>();

        for (final int curentSet[] : this.MOVES) {
            xDestCandidate = this.xPos + curentSet[0];
            yDestCandidate = this.yPos + curentSet[1];

            if ( BoardFunc.isOnThePlane(xDestCandidate, yDestCandidate)) {
                final Square candidate = board.getSquare(xDestCandidate, yDestCandidate);
                if ((candidate.isEmpty()) && (xDestCandidate == 0)) {
                    legalMoves.add(new MajorMove(board, this, xDestCandidate, yDestCandidate));
                } else if (!candidate.isEmpty() && Math.abs(xDestCandidate) == 1){
                    final Piece pieceInDestination = candidate.getPiece();
                    final Color pieceColor = pieceInDestination.getMyColor();
                    if (this.getMyColor() != pieceColor) {
                        legalMoves.add(new AttackMove(board, this, xDestCandidate,
                                yDestCandidate, pieceInDestination));
                    }
                }
            }

        }
        return Collections.unmodifiableSet(legalMoves);
    }
}
