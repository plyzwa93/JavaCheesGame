package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;


public final class Knight extends Piece {

    public Knight(int xPos, int ypos, Color myColor) {
        super(xPos, ypos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1} };
        return tmp;
    }
}

