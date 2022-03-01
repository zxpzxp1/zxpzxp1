package com.homework.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homework.core.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:24
 **/
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    List<User> pageList(@Param("offset") int offset,
                           @Param("pagesize") int pagesize,
                           @Param("username") String username);

    List<User> findAll(@Param("username") String username);

    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize,
                      @Param("username") String username);

    User loadByUserName(@Param("username") String username);

    User getUserById(@Param("id") int id);

    List<User> getUsersByIds(@Param("ids") String[] ids);

    int save(User user);

    int update(User user);

    int delete(@Param("id") int id);
}