package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

public class Knight extends Chessmen {
    public Knight(Color color, int X, int Y) {
        super(getSymbol(color),color, X, Y);
    }


    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♘"; // Символ белого коня
            case BLACK:
                return "♞"; // Символ черного коня
            default:
                return ""; // Если передан недопустимый цвет, возвращаем пустую строку
        }
    }



    public boolean checkingValidMoves(int newX, int newY, ChessBoard chessBoard) {
        int currentX = getX();
        int currentY = getY();

        if (!chessBoard.isValidPosition(newX, newY)) {
            return false;
        }

        int deltaX = Math.abs(newX - currentX);
        int deltaY = Math.abs(newY - currentY);
        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            if (chessBoard.getChessmen(newX, newY).getColor() == getColor()) {
                return false;
            }
            return true;
        }
        return false;
    }
}
