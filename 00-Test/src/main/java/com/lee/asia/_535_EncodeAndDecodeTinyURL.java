package com.lee.asia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: xiong.qiang
 * @date: 2023/5/10 11:22
 */
public class _535_EncodeAndDecodeTinyURL {
    private static Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        //生成一个8位的key 减少Hash冲突的可能 理论上越长越不容易冲突
        String key = getRandomString(8);
        while (map.containsKey(key)) {
            key = getRandomString(8);
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        //拿到key
        int p = shortUrl.lastIndexOf('/') + 1;
        String key = shortUrl.substring(p);
        return map.get(key);
    }

    /**
     * 生成一个length长度的字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String randomString = getRandomString(4);
        System.out.println(randomString);
        String encode = encode(randomString);
        System.out.println(encode);
        String decode = decode(encode);
        System.out.println(decode);
    }

}
