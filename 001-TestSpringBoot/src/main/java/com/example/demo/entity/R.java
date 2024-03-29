package com.example.demo.entity;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 16:20
 */
//因为继承了HashMap类, HashMap类已经实现了'Serializable'接口，因此'R'类也自动继承了'Serializable'的功能
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R setData(Object data) {
        put("data", data);
        return this;

    }

    /**
     * @param key 获取指定key的名字
     */
    public <T> T getData(String key, TypeReference<T> typeReference) {
        // get("data") 默认是map类型 所以再由map转成string再转json,	json再转化成指定的类型
        Object data = get(key);
        return JSON.parseObject(JSON.toJSONString(data), typeReference);
    }


    //利用fastjson进行复杂类型逆转
    public <T> T getData(TypeReference<T> typeReference) {
        // get("data") 默认是map类型 所以再由map转成string再转json,	json再转化成指定的类型
        Object data = get("data"); //默认是map类型  需要转化成json类型
        String s = JSON.toJSONString(data);
        //转化成指定的类型
        T t = JSON.parseObject(s, typeReference);
        return t;
    }

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object obj) {
        R r = new R();
        r.put("code", 200);
        r.put("data", obj);
        return r;
    }


    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getCode() {
        return (Integer) this.get("code");
    }

}
