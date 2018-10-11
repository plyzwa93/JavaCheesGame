package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;

public final class Tower extends Piece {

    public Tower(int xPos, int yPos, Color myColor) {
        super(xPos, yPos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = new int[28][2];
        int j=-7;
        for (int i=0;i<=27;i++) {
            if (j==0) { j=1;}
            tmp[i][0] = j;
            tmp[i][1] = 0;
            System.out.println(tmp[i][0] +" || "+tmp[i][1]);
            i++;
            tmp[i][0] = 0;
            tmp[i][1] = j++;
            System.out.println(tmp[i][0] +" || "+tmp[i][1]);
        }
        return tmp;
    }
}
