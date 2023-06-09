package com.collection;

import com.lee.common.TreeNode;
import lombok.val;

import java.util.*;

/**
 * @author: xiong.qiang
 * @date: 2023/6/5 14:05
 * @Description: 列表类的简单实践
 */
public class MyList {
    private int[] nums;
    private int capacity = 10;
    private int size = 0;

    //每次列表扩容的倍数
    private int extendRatio  = 2 ;

    public MyList(){
        nums = new int[10];
    }
    public int size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }
    public int get(int index){
        if (index < 0  || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        return nums[index];
    }
    public void add(int num){
        //元素超过容量就触发扩容
        if (size == capacity){
            extendCapacity();
        }
        nums[size] = num;
        size++;

    }

    //列表扩容
    public void extendCapacity() {
        nums = Arrays.copyOf(nums,nums.length * extendRatio);
        capacity = nums.length;
    }
    public int[] toArray(){
        int size = size();
        int[] nums= new int[size];
        for(int i = 0; i<size;i++){
            nums[i] =get(i);
        }
        return  nums;
    }
    // 在计算机中，数据读写熟读排序是"硬盘 < 内存 <  CPU 缓存" 当我们访问数组元素时， 计算机不仅会加载它，
    // 还会缓存器周围的其他数据，从而借助高速缓存来提升后续操作的执行速度，链表则不然， 计算器只能诶个的缓存各个节点，这样的多次"搬运"降低了整体效率

    //链表只能挨个的缓存各个节点，降低了整体的效率

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(4));
        Queue<Character> queue = new LinkedList<>();
        queue.offer('s');
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"as");
        map.put(2,"tt");

    }
}

