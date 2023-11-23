package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.e_diary.generator.entity.UserResourceRelationEntity;
import com.group.e_diary.generator.service.UserResourceRelationService;
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
@RequestMapping("api/relation")
public class UserResourceRelationController {
    @Autowired
    private UserResourceRelationService userResourceRelationService;

    /**
     * 列表
     */
    @GetMapping("/likes/{id}")
    public R list(@PathVariable("id") Long id){
        //获取某个用户所有喜欢的素材
        List<UserResourceRelationEntity> userResourceRelationEntities = userResourceRelationService.list(new QueryWrapper<UserResourceRelationEntity>().eq("user_id", id));
        List<Long> list = userResourceRelationEntities.stream().map(userResourceRelation -> userResourceRelation.getResourceId()).collect(Collectors.toList());
        return R.ok().put("data", list);
    }


    /**
     * 保存
     */
    @PostMapping("/create")
    public R save(@RequestBody UserResourceRelationEntity userResourceRelation){
        //喜欢素材
		userResourceRelationService.save(userResourceRelation);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody UserResourceRelationEntity userResourceRelation){
        //取消喜欢
		userResourceRelationService.remove(new QueryWrapper<UserResourceRelationEntity>().eq("user_id",userResourceRelation.getUserId()).eq("resource_id",userResourceRelation.getResourceId()));

        return R.ok();
    }

}
