package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 15:33
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {
    private String code;
    private String msg;
}
