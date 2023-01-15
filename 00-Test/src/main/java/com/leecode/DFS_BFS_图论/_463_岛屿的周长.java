package com.leecode.DFS_BFS_图论;

public class _463_岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        //dfs到边界情况
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        // dfs到0的情况
        if (grid[r][c] == 0) {
            return 1;
        }
        //这里是dfs到1已经变成了2后的情况
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

}
