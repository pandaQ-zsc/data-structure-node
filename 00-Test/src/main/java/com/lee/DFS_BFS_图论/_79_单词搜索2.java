package com.lee.DFS_BFS_图论;


public class _79_单词搜索2 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index >= word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, index + 1, i + 1, j, visited)) {
            return true;
        } else if (dfs(board, word, index +1, i - 1, j, visited)) {
            return true;
        } else if (dfs(board, word, index + 1, i , j+1, visited)) {
            return true;
        } else if (dfs(board, word, index + 1, i , j-1, visited)) {
            return true;
        } else{
            visited[i][j] = false;
            return false;
        }
    }

}
