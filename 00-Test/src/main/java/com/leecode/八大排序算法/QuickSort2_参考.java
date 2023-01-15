package com.leecode.八大排序算法;

/**
 * 快速排序
 */
//性能最好的情况：轴点左右元素数量比较均匀
//性能最差的情况：轴点左右元素数量极度不均匀
// 最坏：7 1 2 3 4 5 6  这里 7作为轴点  -->
//      6 1 2 3 4 5 7  然后 6又最为轴点 -->
//      5 1 2 3 4 6 7
public class QuickSort2_参考 {
    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,5,2,1,7,10,21,1,3,5,21,44};
//        int[] arrays = new int[]{10,9,8,7,6,5,4,3,2,1};
         sort(0, arrays.length, arrays);
        for (int array : arrays) {
            System.out.print("_" + array + "_");

        }
    }
    /**
     * 对 [begin, end) 范围的元素进行快速排序
     */
    private static void sort(int begin, int end, int[] arrays) {
        if ( end - begin < 2) return;
        //确定轴点位置作用是在于可以让轴点左边元素全部小于轴点元素，
        // 轴点元素右边全部大于轴点元素  O(n)
        int mid = pivotIndex(begin,end,arrays);
        sort(begin,mid,arrays);
        sort(mid+1,end,arrays);
    }
    /**
     * 构造出 [begin, end) 范围的轴点元素
     * @return 轴点元素的最终位置
     */
    public static int pivotIndex(int begin, int end, int[] arrays) {
        //  begin  - x      x : 为begin-end之间的随机数
        swap(begin, begin + (int) Math.random() * (end - begin), arrays);
        //备份begin位置的元素
        int pivot = arrays[begin];
        // end指向最后一个元素
        end--;

        while(begin <end){
            //这里面的比较主要是根据轴点比较， 因为快速排序主要是将比轴点小的放左边，比轴点大的放右边
           while(begin < end){    //先从右往左扫描
                if(arrays[end] > pivot){
                    end--;
                }else {  // 右边元素  <= 轴点元素
                    arrays[begin++] = arrays[end];
                    break;
                }
           }
           while(begin < end){//从左往右扫描
               if (arrays[begin] < pivot){ // 左边元素< 轴点元素
                    begin ++;
               }else {              //左边元素 >= 轴点元素
                   arrays[end--] = arrays[begin];
                   break;
               }
           }
        }
        //将备份的数据放到最后确定的begin位置 ， 返回begin
        arrays[begin] = pivot;
        return begin;
    }

    public static void swap(int i, int j, int[] arrays) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }

}
