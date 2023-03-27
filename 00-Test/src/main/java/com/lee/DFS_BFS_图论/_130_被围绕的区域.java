package com.lee.DFS_BFS_图论;

public class _130_被围绕的区域 {
    //首先对边界上每一个'O'做深度优先搜索，
    // 将与其相连的所有'O'改为'-'。然后遍历矩阵，
    // 将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'
        int row,col;
        public void solve(char[][] board) {
            if(board==null||board.length==0)
                return ;
            row=board.length;
            col=board[0].length;
            for(int i=0;i<row;i++){     //对第一列和最后一列的所有O进行深度优先搜索
                dfs(board,i,0);
                dfs(board,i,col-1);
            }
            for(int j=0;j<col;j++){
                dfs(board,0,j);     //对第一行和最后一行的所有O进行深度优先搜索
                dfs(board,row-1,j);
            }
            for(int i=0;i<row;i++){    //遍历矩阵，将O变为X，将-变为O
                for(int j=0;j<col;j++){
                    if(board[i][j]=='O')
                        board[i][j]='X';
                    if(board[i][j]=='-')
                        board[i][j]='O';
                }
            }
            return ;
        }
        /**
         * 使用递归进行深度优先搜索
         */
        public void dfs(char[][] board,int i,int j){
            if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')   //递归终止条件判断
                return;
            board[i][j]='-';    //将当前O更改为-
            dfs(board,i-1,j);   //递归该点上方的点
            dfs(board,i+1,j);   //递归该点下方的点
            dfs(board,i,j-1);   //递归该点左边的点
            dfs(board,i,j+1);   //递归该点右边的点
            return ;
        }
}
