var  twoSum = function (nums,target){
    let hash = {};
    for (let i = 0; i < nums.length; i++) {
        if (hash[target  - nums[i]] !==undefined){
            return [i,hash[target - nums[i]]];
        }
        hash[nums[i]] =i;
    }
    return [];
}

console.log(twoSum([2,7,11,15],18))