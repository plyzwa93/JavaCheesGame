package com.plyzwa;

import com.plyzwa.board.Board;
import com.plyzwa.board.Square;
import com.plyzwa.pieces.*;

public class Main {
    public static void main(String[] args) {
        Square.getEmptySquareMap();
        Bishop b = new Bishop(1,2,Color.BLACK);
        Tower t = new Tower(2, 5, Color.WHITE);
        Queen q = new Queen(3, 4, Color.BLACK);
        Pawn p = new Pawn(3, 6, Color.WHITE);
        King k = new King(5, 6, Color.BLACK);

        Board board = Board.CrateInitialBoard();

    }
}