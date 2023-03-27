package com.lee.DFS_BFS_图论;

public class _200_岛屿数量 {
    //输入：grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //输出：1
    //
    private int res;
    public int numIslands(char[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }
    private void dfsGrid(char[][] grid, int row, int col) {
        //判断
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[row][col] != '1') {
            return;
        }
        // 将格子标记为「已遍历过」
        grid[row][col] = '2';
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);
    }
}
