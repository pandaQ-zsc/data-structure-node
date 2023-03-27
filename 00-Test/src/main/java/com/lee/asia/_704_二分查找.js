var search = function (nums, target) {
    let mid, left = 0, right = nums.length - 1;
    while (left <= right) {
        mid = left + ((right - left) >> 1);
        if (target < nums[mid]) {
            right = mid - 1;
        } else if (target > nums[mid]) {
            left = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
let res = search([1, 2, 3, 4, 5, 6, 7], 5)
console.log(res)