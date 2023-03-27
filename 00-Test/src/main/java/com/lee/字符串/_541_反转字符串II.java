package com.lee.字符串;

public class _541_反转字符串II {
    //每隔k个反转k个，末尾不够k个时全部反转；
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        int length = s.length();
        while(start < length){
            StringBuilder tmp = new StringBuilder();
            int firstK = Math.min(start + k,length);
            int secondK = Math.min(start + 2*k,length);
            // length (k,2k)
            tmp.append(s,start,firstK);
            res.append(tmp.reverse());
            if (firstK < secondK){
                tmp.append(s,firstK,secondK);
                res.append(tmp.reverse());
            }

            start = start + 2*k;
        }
        return res.toString();
    }
    public String reverseStr2(String s, int k) {
        StringBuilder res = new StringBuilder();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuilder temp = new StringBuilder();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = Math.min(start + k, length);
            int secondK = Math.min(start + (2 * k), length);

            //无论start所处位置，至少会反转一次
            temp.append(s, start, firstK);
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s, firstK, secondK);
            }
            start += (2 * k);
        }
        return res.toString();
    }
}
