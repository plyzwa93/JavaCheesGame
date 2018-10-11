package com.plyzwa.board;

import com.plyzwa.pieces.Piece;

public final class EmptySquare extends Square {

    public EmptySquare(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
