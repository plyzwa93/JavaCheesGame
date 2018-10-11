package com.plyzwa.board;

import com.plyzwa.pieces.Piece;

public final class OccupiedSquare extends Square {

    private final Piece pieceOnSquare;


    public OccupiedSquare(int xPos, int yPos, Piece pieceOnSquare) {
        super(xPos, yPos);
        this.pieceOnSquare = pieceOnSquare;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnSquare;
    }
}
