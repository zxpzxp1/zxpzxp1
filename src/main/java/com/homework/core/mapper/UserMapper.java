package com.homework.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homework.core.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:24
 **/

public interface UserMapper  extends BaseMapper<User> {
    int save(User jobUser);

    int update(User jobUser);

    int delete(@Param("id") int id);
}