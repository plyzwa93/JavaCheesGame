package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;

public final class  King extends Piece {
    public King(int xPos, int yPos, Color myColor) {
        super(xPos, yPos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
                {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        return tmp;
    }
}
