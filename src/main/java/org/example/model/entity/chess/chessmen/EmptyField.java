package org.example.model.entity.chess.chessmen;

import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

public class EmptyField extends Chessmen {

    public EmptyField(int X, int Y) {
        super("", Color.EMPTYFIELD, X, Y);
    }
    public boolean checkingValidMoves(int newX, int newY, ChessBoard chessBoard) {
        return false;
    }
}
