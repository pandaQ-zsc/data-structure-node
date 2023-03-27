package com.lee.asia;

//【笔记】这道题（据说）花费了计算机科学界的传奇人物Don Knuth 24小时才解出来。并且我只见过一个人（注：Keith Amling）用更短时间解出此题。
//快慢指针，一个时间复杂度为O(N)的算法。
//其一，对于链表问题，使用快慢指针可以判断是否有环。
//其二，本题可以使用数组配合下标，抽象成链表问题。但是难点是要定位环的入口位置。
//举个例子：nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]，构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
//其三，快慢指针问题，会在环内的[9]->1->5->3->6->8->7->[9]任何一个节点追上，不一定是在[9]处相碰，事实上会在7处碰上。
//其四，必须另起一个for循环定位环入口位置[9]。这里需要数学证明。
//对“其四”简单说明一下，既然快慢指针在环内的某处已经相碰了。那么，第二个for循环遍历时，res指针还是在不停的绕环走，但是必定和i指针在环入口处相碰。
//int findDuplicate(vector<int>& nums) {
//    int res = 0;
//    for (int fast = 0; res != fast || fast == 0;){
//        res = nums[res];
//        fast = nums[nums[fast]];
//    }
//    cout << res;
//    for (int i = 0; res != i; i = nums[i]){
//        res = nums[res];
//    }
//    return res;
//}

///给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
//假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
//链接：https://leetcode.cn/problems/find-the-duplicate-number
//输入：nums = [1,3,4,2,2]
//输出：2

//输入：nums = [3,1,3,4,2]
//输出：3


public class _287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                slow = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }
}
