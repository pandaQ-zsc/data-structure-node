/**
 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

 注意：如果对空文本输入退格字符，文本继续为空。

 示例 1：
 输入：s = "ab#c", t = "ad#c"
 输出：true
 解释：s 和 t 都会变成 "ac"。

 示例 2：

 输入：s = "ab##", t = "c#d#"
 输出：true
 解释：s 和 t 都会变成 ""。

 示例 3：

 输入：s = "a#c", t = "b"
 输出：false
 解释：s 会变成 "c"，但 t 仍然是 "b"。

 链接：https://leetcode.cn/problems/backspace-string-compare
 *
 */

var backspaceCompare = function (s, t) {
    s = s.split('');
    t = t.split('');
    //先对s数组处理
    for (let i = 0; i  < s.length; i++) {
        if (s[i] === '#' && i === 0){
            s.splice(0,1);
            i=-1
        }

        if (s[i] === '#' && i !== 0) {
            s.splice(i - 1, 2)
            i = -1;
        }
    }
    //再对t数组处理
    for (let i = 0; i < t.length; i++) {
        if (t[i] === '#' && i === 0){
            t.splice(0,1);
            i=-1
        }
        if (t[i] === '#' && i !== 0) {
            t.splice(i - 1, 2)
            i = -1;
        }
    }
    s = s.toString();
    t = t.toString();
    return s === t;
};

let res = backspaceCompare("a##c", "#a#c")
console.log(res);