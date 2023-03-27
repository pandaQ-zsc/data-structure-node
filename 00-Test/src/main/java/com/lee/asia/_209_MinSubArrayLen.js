////示例 1：
// //
// //输入：target = 7, nums = [2,3,1,2,4,3]
// //输出：2
// //解释：子数组[4,3]是该条件下的长度最小的子数组。
// var minSubArrayLen = function (nums, target) {
//     let l = 0, r = 0, sum = 0;
//     let min = Infinity;
//     while (r < nums.length) {
//         sum += nums[r++]
//         while (sum >= target) {
//             sum -= nums[l++]
//             min = Math.min(r - l + 1, min);
//             break;
//         }
//     }
//     return min === Infinity ? 0 : min;
// }

var minSubArrayLen = function (nums, target) {
    let l = 0, r = 0, sum = 0;
    let min = Infinity;
    while (r < nums.length) {
        sum += nums[r++];
        while (sum >= target) {
            sum -= nums[l++];
            min = Math.min(r - l + 1, min);
        }
    }
    return min == Infinity ? 0 : min;
    
}

let res = minSubArrayLen([1, 2, 3, 4, 5], 11);
console.log(res);
