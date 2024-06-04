var reverseString = function(s){
    let l = 0;
    let r = s.length-1;
    while( l < r){
        [s[l],s[r]] = [s[r],s[l]]
        l++;
        r--;
    }
    console.log(s)
}
 var reverseString2 = function(s){
    s.reverse();
 }
reverseString(["h","e","l","l","o"])