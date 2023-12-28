package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

import static org.example.enums.Color.EMPTYFIELD;

public class Bishop extends Chessmen {
    public Bishop(Color color, int X, int Y) {
        super("♔♚",color, X, Y);
    }

    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♗"; // Символ белого слона
            case BLACK:
                return "♝"; // Символ черного слона
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

        // Проверяем, что слон движется по диагонали
        int deltaX = Math.abs(newX - currentX);
        int deltaY = Math.abs(newY - currentY);
        if (deltaX != deltaY) {
            return false;
        }

        int stepX = Integer.compare(newX, currentX);
        int stepY = Integer.compare(newY, currentY);
        int x = currentX + stepX;
        int y = currentY + stepY;
        while (x != newX || y != newY) {
            if (chessBoard.getChessmen(x, y).getColor() != EMPTYFIELD) {
                return false;
            }
            x += stepX;
            y += stepY;
        }

        // Проверяем, что на новой позиции нет другой фигуры того же цвета
        if (chessBoard.getChessmen(newX, newY).getColor() == getColor()) {
            return false;
        }

        return true;
    }
}
