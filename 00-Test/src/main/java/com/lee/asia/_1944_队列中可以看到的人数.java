package com.lee.asia;

import java.util.Stack;

/**
 * @author Xiong Qiang
 * @date 2024/6/2 17:25
 */

public class _1944_队列中可以看到的人数 {

  //解释：
  //第 0 个人能看到编号为 1 ，2 和 4 的人。
  //第 1 个人能看到编号为 2 的人。
  //第 2 个人能看到编号为 3 和 4 的人。
  //第 3 个人能看到编号为 4 的人。
  //第 4 个人能看到编号为 5 的人。
  //第 5 个人谁也看不到因为他右边没人。

  //输入：heights = [10,6,8,5,11,9]
  //输出：[3,1,2,1,1,0] 


  public static int[] canSeePersonsCount(int[] heights) {
    //单调栈
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[heights.length];
    for (int i = heights.length-1; i >=0 ; i--) {
      //每次弹出的元素，都是在heights[i]右侧且比height[i]小的元素（无法维持单调递增栈）
        while (!stack.isEmpty() && heights[i] > stack.peek()){
            res[i]++;
            stack.pop();
        }
        //维持单调递增栈
        //此时的height[i] < stack.peek()，栈顶元素是heights[i]右侧收个大于它的元素
      // 也就是栈顶是大的元素（可见的）
        if (!stack.isEmpty()) res[i]++;
        //针对首个元素
        stack.push(heights[i]);
    }
    return res;
  }



  //等待完成的函数
  public static int[] canSeePersonsCount2(int[] heights) {
    if(heights.length>=2){
      heights[heights.length-1] = 0;
      heights[heights.length-2] = 1;
    }else if (heights.length ==2){
      return new int[]{1,0};
    }else {
      return new int[]{0};
    }
    for (int i = 0; i < heights.length; i++) {
      for (int j = i+1; j <heights.length ; j++) {
        int heightNum = 1;
        if (heights[i] > heights[i+1]){
          heightNum++;
        }else {
          heights[i] = heightNum;
          continue;
        }
      }
    }
    
    return heights;
  }

  public static void main(String[] args) {

  }
}
