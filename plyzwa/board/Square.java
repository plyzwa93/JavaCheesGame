package com.plyzwa.board;

import com.plyzwa.pieces.Piece;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Square {

    protected final int xPos;
    protected final int yPos;

    public Square(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public abstract boolean isEmpty();
    public abstract Piece getPiece();


    public static Square createSquare(int x, int y, Piece piece) {
        if (piece == null) {
            return Square.getEmptySquareMap().get( "X"+x+"Y"+y);
        } else {
            return new OccupiedSquare(x, y, piece);
        }
    }

    private static final Map<String, EmptySquare> EMPTY_SQUARE_MAP = allPosibleEmptySquares();

    /**
     * Create all possible empty squares
     * @return empty squares map
     */
    private static Map<String,EmptySquare> allPosibleEmptySquares() {

        Map<String, EmptySquare> emptySquareMap = new HashMap<>();

        for (int x=1;x<=8;x++) {
            for (int y=1;y<=8;y++) {
                String tmp = "X"+x+"Y"+y;
                emptySquareMap.put(tmp, new EmptySquare(x, y));
                System.out.println(tmp);
            }
        }
        return Collections.unmodifiableMap(emptySquareMap);
    }

    public static Map<String, EmptySquare> getEmptySquareMap() {
        return EMPTY_SQUARE_MAP;
    }
}


