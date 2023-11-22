package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public R register(@RequestBody UserEntity user){
        //TODO 创建用户
		userService.save(user);
        return R.ok();
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public R login(@RequestBody UserEntity user){
        //TODO 登陆用户
        userService.save(user);
        return R.ok();
    }


}
