package com.leecode.双指针;

public class _345_反转字符串中的元音字母 {
    public static String reverseVowels(String s) {
        int l =0;
        int r= s.length()-1;
        char[] arr = s.toCharArray();
        while(l<r){
            if (isVowel(arr[l])&&isVowel(arr[r])) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
//            }else if (isVowel(arr[l]) && !isVowel(arr[r])){
//                r--;
//            }else {
//                l++;
//            }
            if (!isVowel(arr[l])) l++;
            if (!isVowel(arr[r])) r--;
        }

        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        reverseVowels("hello");
    }
}
