package com.homework.core.controller;

import com.homework.common.bean.ResponseCode;
import com.homework.common.bean.ReturnT;
import com.homework.core.entity.User;
import com.homework.core.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.homework.common.bean.ReturnT.FAIL_CODE;

/**
 * @className: UserController
 * @description: TODO 类描述
 * @author: zxp
 * @date: 2022-03-01 20:23
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户信息接口")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/pageList")
    @ApiOperation("用户列表")
    public ReturnT<Map<String, Object>> pageList(@RequestParam(required = false, defaultValue = "1") int current,
                                                      @RequestParam(required = false, defaultValue = "10") int size,
                                                      String username) {

        // page list
        List<User> list = userMapper.pageList((current - 1) * size, size, username);
        int recordsTotal = userMapper.pageListCount((current - 1) * size, size, username);

        // package result
        Map<String, Object> maps = new HashMap<>();
        maps.put("recordsTotal", recordsTotal);        // 总记录数
        maps.put("recordsFiltered", recordsTotal);    // 过滤后的总记录数
        maps.put("data", list);                    // 分页列表
        return new ReturnT<>(maps);
    }
    @PostMapping("/add")
    @ApiOperation("添加用户")
    public ReturnT<String> add(@RequestBody User user) {
        user.setUsername(user.getUsername().trim());
        user.setPassword(user.getPassword().trim());
        user.setPassword(user.getPassword());
        User existUser = userMapper.loadByUserName(user.getUsername());
        if (existUser != null) {
            return new ReturnT<>(FAIL_CODE, "user_username_repeat");
        }
        userMapper.save(user);
        return ReturnT.SUCCESS;
    }
    @GetMapping("/list")
    @ApiOperation("用户列表")
    public ReturnT<List<User>> list(String username) {

        // page list
        List<User> list = userMapper.findAll(username);
        return new ReturnT<>(list);
    }
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation("删除用户")
    public ReturnT<String> remove(int id) {
        int result = userMapper.delete(id);
        return result != 1 ? ReturnT.FAIL : ReturnT.SUCCESS;
    }
}