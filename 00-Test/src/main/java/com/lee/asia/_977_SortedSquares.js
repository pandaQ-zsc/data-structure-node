var sortedSquares = function (nums) {
    let index = nums.length - 1;
    let res = new Array(nums.length).fill(0);
    let l = 0;
    let r = nums.length - 1;
    while (l <= r) {
        if (nums[l] * nums[l] < nums[r] * nums[r]) {
            res[index--] = nums[r] * nums[r];
            r--;
        } else {
            res[index--] = nums[l] * nums[l];
            l++;
        }
    }
    return res;
}

let a = sortedSquares([-7, -3, 2, 3, 11]);
console.log(a)