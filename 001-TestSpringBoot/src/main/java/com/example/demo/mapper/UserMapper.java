package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: xiong.qiang
 * @date: 2023/3/1 10:20
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
