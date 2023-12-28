package org.example.model.entity.chess;

import lombok.Getter;
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
            System.out.println(board.toString());
            if (isWhiteMove) {
                makeMove(chessGame);
            } else {
                makeMove(chessGame);
            }
            isGameOver = isGameOver();
            System.out.println(board.toString());
            isWhiteMove = !isWhiteMove;
        }
    }

    public void makeMove(ChessGame chessGame) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты фигуры, которую хотите переместить: ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        System.out.println("Введите координаты клетки, куда вы хотите переместить: ");
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        Chessmen chessman = chessGame.getBoard().getChessmen(startX, startY);
        chessman.move(endX, endY, chessGame.getBoard());
    }

    public boolean isGameOver() {
        return false;
    }

}
