package com.st809.interview.questions.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            bfs(board, 0, col);
            bfs(board, board.length - 1, col);
        }
        for (int row = 0; row < board.length; row++) {
            bfs(board, row, 0);
            bfs(board, row, board[0].length -1);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'M') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

    }

    private static void bfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        Deque<Coord> queue = new ArrayDeque<>();
        queue.add(new Coord(row, col));
        while (!queue.isEmpty()) {
            Coord coord = queue.pop();
            if (board[coord.row][coord.col] == 'O') {
                board[coord.row][coord.col] = 'M';
                if (coord.row - 1 >= 0) {
                    queue.add(new Coord(coord.row - 1, coord.col));
                }
                if (coord.row + 1 < board.length) {
                    queue.add(new Coord(coord.row + 1, coord.col));
                }
                if (coord.col - 1 >= 0) {
                    queue.add(new Coord(coord.row, coord.col - 1));
                }
                if (coord.col + 1 < board[0].length) {
                    queue.add(new Coord(coord.row, coord.col + 1));
                }
            }
        }

    }

    private static class Coord {
        public final int row;

        public final int col;

        private Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                         {'X', 'O', 'O', 'O'},
                         {'X', 'X', 'O', 'X'},
                         {'X', 'O', 'X', 'X'},
                         {'X', 'X', 'X', 'X'},
                        };
        printBoard(board);
        SurroundedRegions.solve(board);
        printBoard(board);

    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
