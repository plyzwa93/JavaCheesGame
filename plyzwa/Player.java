package com.plyzwa;

import com.plyzwa.board.Board;
import com.plyzwa.pieces.King;
import com.plyzwa.pieces.Move;
import com.plyzwa.pieces.Piece;

import java.util.Collection;

public class Player {

    protected final Board board;
    protected final King king;
    protected final Collection<Move> legalMoves;

    public Player(Board board, Collection<Move> legalMoves,
            Collection<Move> oponentMoves) {
        this.board = board;
        this.legalMoves = legalMoves;
        this.king = kingMethod();
    }

    private King kingMethod() {
        for (Piece piece : get)
    }
}
