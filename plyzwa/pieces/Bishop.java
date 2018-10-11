package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;


public final class Bishop extends Piece {

    public Bishop(int xPos, int ypos, Color myColor) {
        super(xPos, ypos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = new int[28][2];
        int incr1=0;
        for (int i=-7;i<=7;i++) {
            for (int j=-7;j<=7;j++) {
                if((Math.abs(i) == Math.abs(j)) && i!=0) {
                    tmp[incr1][0] = i;
                    tmp[incr1][1] = j;
                    System.out.println(i+" || "+j);
                    incr1++;
                }
            }
        }
        return tmp;
    }
}