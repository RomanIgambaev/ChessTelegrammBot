package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

public class King extends Chessmen {
    public King(Color color, int x, int y) {
        super(getSymbol(color), color, x, y);
    }

    private static String getSymbol(Color color) {
        switch (color) {
            case WHITE:
                return "♔";
            case BLACK:
                return "♚";
            default:
                return "";
        }
    }


    public boolean checkingValidMoves(int newX, int newY, ChessBoard chessBoard) {
        int currentX = getX();
        int currentY = getY();

        int deltaX = Math.abs(newX - currentX);
        int deltaY = Math.abs(newY - currentY);

        if (!chessBoard.isValidPosition(newX, newY)) {
            System.out.println("Invalid move: the position is outside the board.");
            return false;
        }

        if (deltaX > 1 || deltaY > 1) {
            System.out.println("Invalid move: the king can only move one square in any direction.");
            return false;
        }

        if (chessBoard.getChessmen(newX, newY).getColor() == getColor()) {
            System.out.println("Invalid move: there is another piece of the same color at the destination.");
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Chessmen chessman = chessBoard.getChessmen(i, j);
                if (chessman.getColor() !=getColor() && chessman.getColor()!= Color.EMPTYFIELD) {
                    for (int k = 0; k < 8; k++) {
                        if (chessman.checkingValidMoves(newX, newY, chessBoard) == true) {
                            System.out.println("Invalid move: the destination square is under attack.");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}

