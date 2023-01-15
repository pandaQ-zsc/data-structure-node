package com.leecode.DFS_BFS_图论;

//计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
public class _695_岛屿的最大面积 {
    int res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                      //计算每个岛屿的面积
                  int tmp = dfs(i,j,grid);
                  res = Math.max(tmp,res);
                  }
              }
        }
        return res;

    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }
        if (grid[row][col] != 1){
            return 0;
        }
        grid[row][col] = 2;
        return  1 + dfs(row,col+1,grid)+dfs(row,col-1,grid)+dfs(row-1,col,grid)+dfs(row+1,col,grid);
    }

}
