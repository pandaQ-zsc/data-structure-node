package com.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: xiong.qiang
 * Date: 2023/1/12 10:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubPerson {
    private int age;
    private String openid;
    private String name;
    private String subName;

}
