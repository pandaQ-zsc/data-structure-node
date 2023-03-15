package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiong.qiang
 * @date: 2023/3/15 11:14
 */

// implements Serializable 已经在 HashMap 中实现了。

public class ResponseData<T> extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //   private  Object data;
    private T data;
    private String code;


    ResponseData() {
        put("code", 200);
        put("msg", "success");
    }

    public static <T> ResponseData<T> error() {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.put("code", 500);
        responseData.put("msg", "false");
        return responseData;
    }

    public ResponseData<T> setData(T data) {
        put("data", data);
        return this;
    }

    public static <E> ResponseData<E> ok() {
        return new ResponseData<>();
    }


    public static <E> ResponseData<E> ok(Map<String, E> map) {
        ResponseData<E> responseData = new ResponseData<>();
        responseData.putAll(map);
        return responseData;
    }

    public static <E> ResponseData<E> ok(E data) {
        return new ResponseData<>();
    }

    @Override
    public ResponseData<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public T getData() {
        return data;
    }

}
