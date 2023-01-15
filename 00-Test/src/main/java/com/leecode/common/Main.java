package com.leecode.common;

import java.util.*;

public class Main {

    public static int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int m = 0;
        int numLength = row * col;
        while(res.size() < numLength){
            for (int i = m; i <col ; i++) {
                res.add(matrix[m][i]);
            }
            if (res.size() == numLength){
                break;
            }
            for (int i = m+1; i <row ; i++) {
                res.add(matrix[i][col-1]);
            }
            if (res.size() == numLength){
                break;
            }
            for (int i = col-2; i > (m-1) ; i--) {
                res.add(matrix[row-1][i]);
            }
            if (res.size() == numLength){
                break;
            }
            for (int i = row-2; i >m ; i--) {
                res.add(matrix[i][m]);
            }
            m++;
            col = col-1;
            row = row-1;
        }
        int [] result = new int[res.size()];
        int cur = 0;
        for(int num : res){
            result[cur++] = num;
        }
        return result;
    }

//    public static void main(String[] args) {
//        int[] ints = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
//        String s = Arrays.toString(ints);
//        System.out.println(s);
//    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _matrix_rows = 0;
        int _matrix_cols = 0;
        _matrix_rows = Integer.parseInt(String.valueOf(in.nextInt()));
        _matrix_cols = Integer.parseInt(String.valueOf(in.nextInt()));

        int[][] _matrix = new int[_matrix_rows][_matrix_cols];
        for(int _matrix_i=0; _matrix_i<_matrix_rows; _matrix_i++) {
            for(int _matrix_j=0; _matrix_j<_matrix_cols; _matrix_j++) {
                _matrix[_matrix_i][_matrix_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Main().spiralOrder(_matrix);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}