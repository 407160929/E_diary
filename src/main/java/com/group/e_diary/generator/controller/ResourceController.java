package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.e_diary.generator.entity.ResourceEntity;
import com.group.e_diary.generator.service.ResourceService;
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
@RequestMapping("api/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * 列表
     */
    @RequestMapping("/list/{id}")
    public R list(@PathVariable("id") Long id){
        //获取某个用户所有素材
        List<ResourceEntity> resourceEntities = resourceService.list(new QueryWrapper<ResourceEntity>().eq("user_id", id));
        List<Long> list = resourceEntities.stream().map(resourceEntity -> resourceEntity.getId()).collect(Collectors.toList());
        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        //获取素材
		ResourceEntity resource = resourceService.getById(id);
        return R.ok().put("resource", resource);
    }

    /**
     * 保存
     */
    @PostMapping("/create")
    public R save(@RequestBody ResourceEntity resource){
        //上传素材
		resourceService.save(resource);
        return R.ok();
    }
    /**
     * 更新
     */
    @PostMapping("/update")
    public R update(@RequestBody ResourceEntity resource){
        //上传素材
        resourceService.updateById(resource);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long id){
        //删除素材
        resourceService.removeById(id);
        return R.ok();
    }

}
