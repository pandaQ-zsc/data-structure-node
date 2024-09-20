let merge = function(nums1, m, nums2, n) {
    //error // let i = nums1.length-1;
    // let j = nums2.length-1;
    let i = m-1;
    let j = n-1
    let cur = nums1.length-1
    while(j>=0){
        if (i>=0 && nums1[i]>nums2[j]){
            nums1[cur--]  = nums1[i--]
        }else {
            nums1[cur--] = nums2[j--]
        }
    }
    return nums1
};

let merge2 = function(nums1, m, nums2, n){
    // nums1.splice(m,nums1.length-m,...nums2)
    // nums1.sort((a,b)=>a-b)
    for(let i =1 ; i!== n ;i++){
        nums1[m+ i] = nums2[i]
    }
}

merge2([1,2,3,0,0,0],3,[2,5,6],3)

// let res = merge([1,2,3,0,0,0],3,[2,5,6],3)
let res = merge([1,2,3,0,0,0],3,[2,5,6],3)
console.log(res);