package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.e_diary.generator.entity.PageEntity;
import com.group.e_diary.generator.service.PageService;
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
@RequestMapping("api/page")
public class PageController {
    @Autowired
    private PageService pageService;

    /**
     * 列表
     */
    @RequestMapping("/list/{id}")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pageService.queryPage(params);
        //todo 获取某个日记的所有页id
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PageEntity page = pageService.getById(id);
        //todo 获取日记页
        return R.ok().put("page", page);
    }

    /**
     * 保存
     */
    @RequestMapping("/create")
    public R save(@RequestBody PageEntity page){
		pageService.save(page);
        //todo 新增日记页
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PageEntity page){
		pageService.updateById(page);
        //todo 更新日记页
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		pageService.removeByIds(Arrays.asList(ids));
        //todo 删除日记页
        return R.ok();
    }

}
