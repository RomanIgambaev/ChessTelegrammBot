package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

public class Paw extends Chessmen {
    public Paw(Color color, int X, int Y) {
        super("♔♚",color, X, Y);
    }

    public boolean checkingValidMoves(int newX, int newY, ChessBoard chessBoard) {
        int currentX = getX();
        int currentY = getY();

        if (!chessBoard.isValidPosition(newX, newY)) {
            System.out.println("Invalid move: the position is outside the board.");
            return false;
        }

        if (newX != currentX + 1) {
            System.out.println("Invalid move: the pawn can only move one square forward vertically.");
            return false;
        }

        if (newY != currentY) {
            System.out.println("Invalid move: the pawn can only move forward without capturing diagonally.");
            return false;
        }

        if (chessBoard.getChessmen(newX, newY).getColor() == getColor()) {
            System.out.println("Invalid move: there is another piece of the same color at the destination.");
            return false;
        }

        setX(newX);
        setY(newY);
        System.out.println("Pawn moved to (" + newX + ", " + newY + ")");
        return true;
    }
    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♙";
            case BLACK:
                return "♟";
            default:
                return "";
        }
    }
}
