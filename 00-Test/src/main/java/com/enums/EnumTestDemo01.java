package com.enums;

/**
 * Author: xiong.qiang
 * Date: 2023/1/16 10:47
 */
public enum EnumTestDemo01 {
    /**
     * 单机模式
     */
    SINGLE(1),
    /**
     * 多人模式
     */
    MULTI(2),
    /**
     * 退出
     */
    EXIT(3);

    public Integer getValue() {
        return status;
    }

    private final Integer status;
    EnumTestDemo01(Integer status){
        this.status = status;
    }

}
