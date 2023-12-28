package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

public class Queen extends Chessmen {
    public Queen(Color color, int X, int Y) {
        super("♔♚",color, X, Y);
    }
    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♕";
            case BLACK:
                return "♛";
            default:
                return "";
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
        if (deltaX != 0 && deltaY != 0 && deltaX != deltaY) {
            return false;
        }

        int stepX = Integer.compare(newX, currentX);
        int stepY = Integer.compare(newY, currentY);
        int x = currentX + stepX;
        int y = currentY + stepY;
        while (x != newX || y != newY) {
            if (chessBoard.getChessmen(x, y).getColor() != Color.EMPTYFIELD) {
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
