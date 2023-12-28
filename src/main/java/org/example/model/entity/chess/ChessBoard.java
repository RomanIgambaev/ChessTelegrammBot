package org.example.model.entity.chess;

import lombok.Getter;
import org.example.enums.Color;
import org.example.model.entity.chess.chessmen.*;

import static org.example.enums.Color.EMPTYFIELD;

@Getter
public class ChessBoard {
    private Chessmen[][] board;

    public ChessBoard() {
        board = originallyPlaceChessman();
    }

    private Chessmen [][] originallyPlaceChessman() {
        Chessmen[][] board = new Chessmen[7][7];
        board[0][0] = new Rock(Color.WHITE,0, 0);
        board[0][1] = new Knight(Color.WHITE,0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE,0, 4);
        board[0][5] = new Bishop(Color.WHITE,0, 5);
        board[0][6] = new Knight(Color.WHITE,0, 6);
        board[0][7] = new Rock(Color.WHITE,0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Paw(Color.WHITE,1, i);
        }

        board[7][0] = new Rock(Color.BLACK,7, 0);
        board[7][1] = new Knight(Color.BLACK,7, 1);
        board[7][2] = new Bishop(Color.BLACK,7, 2);
        board[7][3] = new Queen(Color.BLACK,7, 3);
        board[7][4] = new King(Color.BLACK,7, 4);
        board[7][5] = new Bishop(Color.BLACK,7, 5);
        board[7][6] = new Knight(Color.BLACK,7, 6);
        board[7][7] = new Rock(Color.BLACK,7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Paw(Color.BLACK,6, i);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new EmptyField(i, j);
                }
            }
        }
        return board;
    }

    public boolean isValidPosition(int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            return false;
        }
        return true;
    }


    public Chessmen getChessmen(int x, int y) {
        return board [x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Chessmen[] row : board) {
            for (Chessmen piece : row) {
                if (piece.getColor() != EMPTYFIELD) {
                    sb.append(piece.getImage()).append(" ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

