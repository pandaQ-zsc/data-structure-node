package com.lee.DFS_BFS_图论;


public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        //用一个数组标记每个点是否访问过
        boolean[][] visited = new boolean[board.length][board[0].length];
        //针对每个点，使用回溯解决
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(flashBack(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean flashBack(char[][] board,String word,int i,int j,int index,boolean[][] visited){
        //如果每个字符都对比完了，返回true
        if(index >= word.length()){
            return true;
        }

        //如果超出边界，返回false
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        //如果该点已访问，返回false
        if(visited[i][j]){
            return false;
        }
        //如果字符不相等，返回false
        if(board[i][j] != word.charAt(index)){
            return false;
        }

        //将该点标记为访问
        visited[i][j] = true;
        //针对每个方向进行递归访问
        if(flashBack(board,word,i + 1,j,index + 1,visited)){
            return true;
        }else if(flashBack(board,word,i,j + 1,index + 1,visited)){
            return true;
        }else if(flashBack(board,word,i - 1,j,index + 1,visited)){
            return true;
        }else if(flashBack(board,word,i,j - 1,index + 1,visited)){
            return true;
        }else{
            //回溯，将该点标记为未访问
            visited[i][j] = false;
            return false;
        }
    }

}
