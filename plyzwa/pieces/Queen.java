package com.plyzwa.pieces;

import com.plyzwa.Color;
import com.plyzwa.board.Board;

public final class Queen extends Piece {
    public Queen(int xPos, int yPos, Color myColor) {
        super(xPos, yPos, myColor);
    }

    @Override
    public boolean isAnythingOnThePath(Board board) {
        return false;
    }

    @Override
    protected int[][] makeArray() {
        int[][] tmp = new int[56][2];
        int incr=0;
        for (int i=-7;i<=7;i++) {
            for (int j=-7;j<=7;j++) {

                if((Math.abs(i) == Math.abs(j)) && j!=0) {
                    tmp[incr][0] = i;
                    tmp[incr][1] = j;
                    System.out.println(tmp[incr][0] +" || "+tmp[incr][1]);
                    incr++;
                }
            }
            if (i==0) {i=1;}
            tmp[incr][0]=i;
            tmp[incr][1]=0;
            System.out.println(tmp[incr][0] +" || "+tmp[incr][1]);
            incr++;
            tmp[incr][0]=0;
            tmp[incr][1]=i;
            System.out.println(tmp[incr][0] +" || "+tmp[incr][1]);
            incr++;
        }
        return tmp;
    }
}
