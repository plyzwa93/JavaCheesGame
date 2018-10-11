package com.plyzwa.pieces;

import com.plyzwa.board.Board;
// This class need improvement
public abstract class Move {

    final Board board;
    final Piece piece;
    final int xDestCord, yDestCord;

    public Move(Board board, Piece piece, int xDestCord, int yDestCord) {
        this.board = board;
        this.piece = piece;
        this.xDestCord = xDestCord;
        this.yDestCord = yDestCord;
    }
}
final class MajorMove extends Move {
    public MajorMove(Board board, Piece piece, int xDestCord, int yDestCord) {
        super(board, piece, xDestCord, yDestCord);
    }
}
final class AttackMove extends Move {
    private Piece attackedPiece;
    public AttackMove(Board board, Piece piece, int xDestCord,
                      int yDestCord, Piece attackedPiece) {
        super(board, piece, xDestCord, yDestCord);
        this.attackedPiece = attackedPiece;
    }
    public Piece getAttackedPiece() {
        return attackedPiece;
    }
}
