var canJump = function(nums) {
    let rightmost = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i<=rightmost){
            rightmost = Math.max(rightmost,nums[i]+i)
        }
        if (rightmost >= nums.length -1) return true
    }
    return  false;
}