var maxProfit = function(prices) {
    if (prices.length<2) return 0 ;
    let max = 0;
    let min = prices[0];
    for (let i = 0; i < prices.length; i++) {
        min = Math.min(min,prices[i]);
        max =Math.max(max,prices[i]-min);
    }
    return max;
}
let res = maxProfit([7,1,5,3,6,4]);
console.log(res);