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


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _287_寻找重复数 {
    //如上图，slow 和 fast 会在环中相遇，先假设一些量：起点到环的入口长度为 m，环的周长为 c，在 fast 和 slow 相遇时 slow 走了 n 步。则 fast 走了 2n 步，fast 比 slow 多走了 n 步，而这 n 步全用在了在环里循环（n%c==0）。
    //当 fast 和 last 相遇之后，我们设置第三个指针 finder，它从起点开始和 slow(在 fast 和 slow 相遇处)同步前进，当 finder 和 slow 相遇时，就是在环的入口处相遇，也就是重复的那个数字相遇。
    //
    //链接：https://leetcode.cn/problems/find-the-duplicate-number/solution/kuai-man-zhi-zhen-de-jie-shi-cong-damien_undoxie-d/
    //为什么 finder 和 slow 相遇在入口?????
    //fast 和 slow 相遇时，slow 在环中行进的距离是 n-m，其中 n%c==0。这时我们再让 slow 前进 m 步——也就是在环中走了 n 步了。而 n%c==0 即 slow 在环里面走的距离是环的周长的整数倍，就回到了环的入口了，而入口就是重复的数字。
    //我们不知道起点到入口的长度 m，所以弄个 finder 和 slow 一起走，他们必定会在入口处相遇
    //
    //note:第一次相遇只是在重复的序列（索引  slow=4  fast = 4,nums[fast] = 2 && nums[slow] =2）中相遇
    public static int findDuplicate(int[] nums) {
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

    //Myself Answer
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int find = 0;
        while (nums[find] != nums[slow]) {
            slow = nums[slow];
            find = nums[find];
        }
        return nums[find];

    }

    public static int findDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int findDuplicate3(int[] nums) {
        int[] res = new int[nums.length + 1];
        for (int num : nums) {
            res[num]++;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] > 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] num = new int[]{1, 3, 4, 2, 2};
//        int[] num = new int[]{2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate3(num));
    }
}