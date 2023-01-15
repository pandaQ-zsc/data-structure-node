package com.leecode.双指针;

public class _633_平方数之和 {
    //如果存在符合条件的a，b，那么a和b一定在0和sqrt(c)之间。
    //最朴素的思路，两层for循环，从0到sqrt(c)，看是否存在符合条件的a和b。相当于遍历了两次从0到sqrt(c)
    //显然，没有双指针快捷，双指针只需要遍历一次即可。**为什么使用双指针不会把正确答案排除在外呢**。我认为这才是需要认真考虑的问题，而不是双指针直接用。我们用a表示第一个数，b表示第二个数。从初始开始考虑，a = 0，b = (int)Math.sqrt(c)
    //if(a*a+b*b<c)，那么显然，a固定的情况下和无论如何变化b值都不会满足当前的条件，由此，**a=0一定不在正确答案中**，所以可以直接排除。
    //反之，if(a*a+b*b>c)，b固定的情况下，当前所有能变化的a值，都不会满足条件，因此，**当前的b也一定不在正确答案中**。
    //综上，双指针法确保正确答案不会被排除。

    //给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
    //输入：c = 5
    //输出：true
    //解释：1 * 1 + 2 * 2 = 5
    // 29  --  (2 -- 5 )
    // 27  -- 1 5
    public boolean judgeSquareSum(int c) {
     long l = 0;
     long r= (long) Math.sqrt(c);
     while(l <= r){
         if (l*l + r*r < c){
             l++;
         }else if (l*l + r*r>c){
             r--;
         }else {
             return true;
         }
     }
     return false;
    }
}
