package com.leecode.DFS_BFS_图论;

public class _200_岛屿数量2 {
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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    res ++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row <0 || row >= grid.length||col < 0 || col >= grid[0].length){
            return;
        }
        if (grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '2';
        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col-1,grid);
        dfs(row,col+1,grid);

    }

}
