package com.plyzwa.board;

public abstract class BoardFunc {
    /**
     *
     * @param x Horizontal X param
     * @param y Vertical Y param
     * @return true if cordinates fit the chess plane
     */
    public static boolean isOnThePlane(int x, int y) {
        if (x>=1 && x<=8 && y>=1 && y<=8) {
            return true;
        } else {
            return false;
        }
    }
    public static String tmpString(int x, int y) {
        return ("X"+x+"Y"+y);
    }
}
