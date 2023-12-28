package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

import static org.example.enums.Color.EMPTYFIELD;

public class Rock extends Chessmen {
    public Rock(Color color, int X, int Y) {
        super(getSymbol(color),color, X, Y);
    }
    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♖";
            case BLACK:
                return "♜";
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

        if (newX != currentX && newY != currentY) {
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
