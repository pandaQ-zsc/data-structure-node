package com.mj;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

public class Main6 {
    public static void main(String[] args) {
//         {
//              "topic_field_name" : "DATA_TYPE",
//              "db_field_name" : "DATA_TYPE",
//              "field_type" : "string",
//              "default_value" : ""
//            }
//
        String res = xlsToSql("     CK_THREAT\tID\tbigint\tNOT NULL\tId值，唯一,不能为null\n" +
                "     AAAA\tID\tbigint\tNOT NULL\tId值，唯一,不能为null\n" +
                "     VVVV\tID\tbigint\tNOT NULL\tId值，唯一,不能为null");
        System.out.println(res);
        stringToJSON2("{\n" +
                "              \"topic_field_name\" : \"DATA_TYPE\",\n" +
                "              \"db_field_name\" : \"DATA_TYPE\",\n" +
                "              \"field_type\" : \"string\",\n" +
                "              \"default_value\" : \"\"\n" +
                "            }");

    }
    // CK_THREAT	ID	bigint	NOT NULL	Id值，唯一,不能为null
    // AAAA	ID	bigint	NOT NULL	Id值，唯一,不能为null
    // VVVV	ID	bigint	NOT NULL	Id值，唯一,不能为null

    private static String xlsToSql(String xlsStr) {
        xlsStr = xlsStr.trim();
        String[] split = xlsStr.split("\n");
        StringBuilder sqlRes = new StringBuilder();
        for (String s : split) {
            String lineString = s;
            lineString = lineString.trim();
            lineString = lineString.replaceAll("\t", " ");
            lineString = lineString.replaceAll("，", ",");
            String[] s1 = lineString.split(" ");
            sqlRes.append("alter talble ").append(s1[0]).append("\n").append("\t").append("add column ").append(s1[1]).append("\t").append(s1[2]).append(";").append("\n");
        }
        String sql = sqlRes.toString();
        System.out.println(sql);
        return sql;
    }

    private static String xlsToField(String xlsStr) {
        xlsStr = xlsStr.trim();
        String[] split = xlsStr.split("\n");
        JSONArray objectArr = new JSONArray();

        for (String s : split) {
            String lineString = s;
            lineString = lineString.replaceAll("\t", " ");
            lineString = lineString.replaceAll("，", ",");
            JSONObject jsonObject = stringToJSON2(lineString);
            objectArr.add(jsonObject);
        }
        return objectArr.toString();
    }


    private static JSONObject stringToJSON2(String s) {
        String[] s1 = s.split(" ");
        JSONObject object = new JSONObject();
        object.put("topic_field_name", s1[1]);
        object.put("db_field_name", s1[1]);
        object.put("field_type", s1[2]);
        if (s1[3].equalsIgnoreCase("NOT")) {
            s1[3] = s1[3].toUpperCase() + " NULL";
            object.put("default_value", s1[3]);
        }
        return object;
    }

}
