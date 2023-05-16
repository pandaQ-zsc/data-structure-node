package com.sort;

import java.util.Arrays;
//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.runoob.com/w3cnote/merge-sort.html
//https://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort_参考 {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        //        int a[] = {60,50,40,30,20,10};
//        int a[] = {30, 40, 60, 10, 20, 50};
	int a[] = {10,20,30,40,50,60};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            //这里是【】
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序

            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int index = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[index++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[index++] = arr[j++];
        }
        index = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[index++];
        }
    }
}
