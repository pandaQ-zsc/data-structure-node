var distributeCandies = function(n, limit){
    ans = 0;
    for(let i = 0; i <=limit ;i++){
        for(let j =0; j <= limit ;j++){
            if (i + j > n){
                break
            }
            if (n-i-j <=limit){
                ans++
            }
        }
    }
    return ans;
}
var i = distributeCandies(5,2);
console.log("answer --------> " +i);