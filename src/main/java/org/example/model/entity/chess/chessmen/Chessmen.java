package org.example.model.entity.chess.chessmen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Color;
import org.example.model.entity.chess.ChessBoard;

@AllArgsConstructor
@Getter
@Setter
public abstract class Chessmen {

    String image;
    Color color;
    int X;
    int Y;

    public boolean checkingValidMoves(int newX, int newY, ChessBoard chessBoard) {
        return false;
    }

    public void move(int newX, int newY, ChessBoard chessBoard) {
        if (checkingValidMoves(newX, newY, chessBoard)) {
            chessBoard.getBoard()[newX][newY] = this;
            chessBoard.getBoard()[getX()][getY()] = new EmptyField(getX(), getY());
            setX(newX);
            setY(newY);
        }
    }
}
