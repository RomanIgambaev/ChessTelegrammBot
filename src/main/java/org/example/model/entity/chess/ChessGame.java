package org.example.model.entity.chess;

import lombok.Getter;
import org.example.enums.Color;
import org.example.model.entity.chess.chessmen.Chessmen;

import java.util.Scanner;

@Getter

public class ChessGame {
    private ChessBoard board;

    public ChessGame() {
        board = new ChessBoard();
    }

    public void startGame(ChessGame chessGame) {
        boolean isGameOver = false;
        boolean isWhiteMove = true;


        while (!isGameOver) {
            System.out.println(getBoard().toString());

            if (isWhiteMove == true) {
                makeMove(chessGame, isWhiteMove);
            } else {
                makeMove(chessGame, isWhiteMove);
            }
            isGameOver = isGameOver();
            System.out.println(getBoard().toString());
            isWhiteMove = !isWhiteMove;
        }
    }

    public void makeMove(ChessGame chessGame, boolean isWhiteMove) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты фигуры, которую хотите переместить: ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        System.out.println("Введите координаты клетки, куда вы хотите переместить: ");
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        Chessmen chessman = chessGame.getBoard().getChessmen(startX, startY);

        if (isWhiteMove == true && chessman.getColor() != Color.BLACK) {
            System.out.println("Неверный ход: фигура,которой вы хотите сходить принадлежит сопернику");
            return;
        } else if (isWhiteMove == false && chessman.getColor() != Color.WHITE) {
            System.out.println("Неверный ход: фигура,которой вы хотите сходить  принадлежит сопернику");
            return;
        }
        chessman.move(endX, endY, chessGame.getBoard());
    }

    public boolean isGameOver() {
        return false;
    }

}
