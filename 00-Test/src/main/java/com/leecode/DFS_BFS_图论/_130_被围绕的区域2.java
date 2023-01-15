package com.leecode.DFS_BFS_图论;

public class _130_被围绕的区域2 {
    //首先对边界上每一个'O'做深度优先搜索，
    // 将与其相连的所有'O'改为'-'。然后遍历矩阵，
    // 将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length-1, board);

        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(0, i, board);
            dfs(board.length-1, i, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if(board[i][j] == 'O') board[i][j] = 'X';
               if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    public static void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') return;
        board[row][col] = 'A';
        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col-1, board);
        dfs(row, col+1, board);
    }

    public static void main(String[] args) {
        solve(new char[][]{{'O'}});
    }
}
