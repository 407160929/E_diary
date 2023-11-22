package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/likes")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userResourceRelationService.queryPage(params);
        //todo 获取某个用户所有喜欢的素材

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId){
		UserResourceRelationEntity userResourceRelation = userResourceRelationService.getById(userId);

        return R.ok().put("userResourceRelation", userResourceRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserResourceRelationEntity userResourceRelation){
		userResourceRelationService.save(userResourceRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserResourceRelationEntity userResourceRelation){
		userResourceRelationService.updateById(userResourceRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] userIds){
		userResourceRelationService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
