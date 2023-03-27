package com.lee.排序_数组;


public class _378_有序矩阵中第K小的元素 {

    //输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    //输出：13
    //解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13

    /*
    思路非常简单：

        找出二维矩阵中最小的数 leftleft，最大的数 rightright，那么第 kk 小的数必定在 leftleft ~ rightright 之间
        mid=(left+right) / 2mid=(left+right)/2；在二维矩阵中寻找小于等于 midmid 的元素个数 countcount
        若这个 countcount 小于 kk，表明第 kk 小的数在右半部分且不包含 midmid，即 left=mid+1left=mid+1, right=rightright=right，又保证了第 kk 小的数在 leftleft ~ rightright 之间
        若这个 countcount 大于 kk，表明第 kk 小的数在左半部分且可能包含 midmid，即 left=leftleft=left, right=midright=mid，又保证了第 kk 小的数在 left~rightleft right 之间
重点：TODO:因为每次循环中都保证了第 k 小的数在 leftleft ~ rightright 之间，当 left==rightleft==right 时，第 kk 小的数即被找出，等于 rightright
        注意：这里的 leftleft midmid rightright 是数值，不是索引位置。

     */
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {  // 当left == right的时候，第k小的数被找出来。等于right
            //TODO 两个int相加可能越界(left + right) / 2 建议换成 left + (right - left) / 2
            int mid = left + (right - left) / 2;
            //找二维矩阵中<=mid的元素总个数
            int count = findLessMid(matrix, mid, row, col);
            if (count < k) {
                //k在右边，不包括Mid  []
                left = mid + 1;
            } else {  //之类会有count = k
                //k在左边，可能包括mid   []
                right = mid;
            }
        }
        return right;
    }

    //找二维矩阵中<=mid的元素总个数
    private int findLessMid(int[][] matrix, int mid, int row, int col) {
        //以列为单位找， 找到每一列最后一个 <= mid 的数即知道每一列有多少个数 <= mid;
        int i = row - 1; //
        int j = 0;
        int count = 0;
        // j <= mid = 5 时候
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                //第j列有i+1个元素 <= mid   -- i+1 表示第i行（mid所在的那一行）
                //  count += i + 1 i是[]所以i+1这里也就是每次加i个，把i行及上面的数量都加上了
                count += i + 1;
                j++;
            } else {
                //第j列目前的数大于mid,需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    public int kthSmallest12(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = left + right / 2;
            int count = findLessCount(matrix, mid, row, col);
            if (k > count) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findLessCount(int[][] matrix, int mid, int row, int col) {
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (mid >= matrix[i][j]) {
                count += i + 1;
                j++ ;
            } else {
                i --;
            }
        }
        return count ;
    }


}
