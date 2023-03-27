package com.lee.asia;

//https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
public class _200_岛屿数量 {
    int res;

    public int numIslands(char[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(res, i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int res, int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(res, i - 1, j, grid);
        dfs(res, i + 1, j, grid);
        dfs(res, i, j + 1, grid);
        dfs(res, i, j - 1, grid);
    }

}
