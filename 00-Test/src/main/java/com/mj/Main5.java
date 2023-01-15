package com.mj;

//{
//      "topic_field_name" : "DATA_TYPE",
//      "db_field_name" : "DATA_TYPE",
//      "field_type" : "string",
//      "default_value" : ""
//    }

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//
//alter table CK_THREAT_LOCAL
//    add column MINING_STAGE            String,
//    add column THREAT_OBJECT           String,
//    add column MINING_HOST             String,
//    add column VICTIM_IP               String,
//    add column RULE_SOURCE             String,
//    add column XFF_HEADER              String,
//    add column SRC_IP_V6               String,
//    add column CONFIDENCE_LEVEL        String,
public class Main5 {
    //  Int32 --> int   Int64 --> string     int 默认 "0",  字符串 ""  int64 "0"
    public static void main(String[] args) throws IOException {
        //获取用户当前路劲
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath + "/CK_THREAD_LOCAL.sql");
        BufferedReader reader = new BufferedReader(new FileReader(currentPath + "/CK_THREAD_LOCAL.sql"));
        int x = 0;
        StringBuffer sb = new StringBuffer();
        String line = null;

        while ((line = reader.readLine()) != null) {
            if (line.contains("add column")) {
                line = line.trim();
                x++;
                String[] s1 = line.split(" ");
                sb.append(s1[2]);
                sb.append(" ");
            }
        }
        String s = sb.toString();
        String columnString = s.substring(0, s.length() - 1);
        System.out.println(columnString);
        String s1 = stringToJSON(columnString);
        System.out.println(s1);
    }


// {
//      "topic_field_name" : "DATA_TYPE",
//      "db_field_name" : "DATA_TYPE",
//      "field_type" : "string",
//      "default_value" : ""
//    }
    private static String stringToJSON(String s) {
        JSONArray objectArr = new JSONArray();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            JSONObject object = new JSONObject();
            object.put("topic_field_name", s1[i]);
            object.put("db_field_name", s1[i]);
            object.put("field_type", "string");
            object.put("default_value", "");
            objectArr.add(object);
        }
        return objectArr.toString();
    }
}
