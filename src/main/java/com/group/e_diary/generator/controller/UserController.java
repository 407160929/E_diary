package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.e_diary.generator.entity.UserEntity;
import com.group.e_diary.generator.service.UserService;
import com.group.common.utils.PageUtils;
import com.group.common.utils.R;



/**
 * 
 *
 * @author xuan
 * @email 407160929@qq.com
 * @date 2023-11-22 19:13:26
 */
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;



    /**
     * 注册
     */
    @PostMapping ("/register")
    public R register(@RequestBody UserEntity user){
		userService.save(user);
        System.out.println(user.getAccount());
        return R.ok();
    }

    /**
     * 登陆
     */
    @PostMapping("/login")
    public R login(@RequestBody UserEntity user){
        return userService.login(user);
    }


}
