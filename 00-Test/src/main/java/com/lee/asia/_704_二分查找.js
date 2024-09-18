var search1 = function (nums, target) {
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

var search = function (nums,targets){
  // let res  = nums.findIndex(e => e === targets);
  let res  = nums.findIndex(function(element,index){
    return element === 5
  });
  console.log(res)
  return res
}
let res = search([1, 2, 3, 5, 6, 7], 5)
console.log(res)
