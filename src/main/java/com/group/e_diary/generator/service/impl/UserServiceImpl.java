package com.group.e_diary.generator.service.impl;

import com.group.common.utils.R;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.common.utils.PageUtils;
import com.group.common.utils.Query;

import com.group.e_diary.generator.dao.UserDao;
import com.group.e_diary.generator.entity.UserEntity;
import com.group.e_diary.generator.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R login(UserEntity user) {

        UserEntity user1 = getOne(new QueryWrapper<UserEntity>().eq("account", user.getAccount()).eq("password", user.getPassword()));
        return user1!=null?R.ok().put("data", user1):R.error(400,"账号或密码错误");
    }

}