package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resourceService.queryPage(params);
        //todo 获取某个用户所有素材
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ResourceEntity resource = resourceService.getById(id);
        //todo 获取素材
        return R.ok().put("resource", resource);
    }

    /**
     * 保存
     */
    @RequestMapping("/create")
    public R save(@RequestBody ResourceEntity resource){
		resourceService.save(resource);
        //todo 上传素材
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ResourceEntity resource){
		resourceService.updateById(resource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		resourceService.removeByIds(Arrays.asList(ids));
        //todo  删除素材
        return R.ok();
    }

}
