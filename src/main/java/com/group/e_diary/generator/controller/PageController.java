package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R list(@PathVariable("id") Long id){
        //获取某个日记的所有页id
        List<PageEntity> pageEntities = pageService.list(new QueryWrapper<PageEntity>().eq("diary_id", id).orderByAsc("index_id"));
        List<Long> list = pageEntities.stream().map(pageEntity -> pageEntity.getId()).collect(Collectors.toList());
        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        //获取日记页

		PageEntity page = pageService.getById(id);
        return R.ok().put("data", page);
    }

    /**
     * 保存
     */
    @PostMapping("/create")
    public R save(@RequestBody PageEntity page){
        //新增日记页
        List<PageEntity> pageEntities = pageService.list(new QueryWrapper<PageEntity>().eq("diary_id", page.getDiaryId()));
        List<Integer> integerList = pageEntities.stream().map(pageEntity -> pageEntity.getIndexId()).collect(Collectors.toList());
        Integer max =0;
        if(integerList.size() > 0){
            max = Collections.max(integerList);
        }
        page.setIndexId(max+1);
        pageService.save(page);
        return R.ok().put("data",page);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody PageEntity page){
        //更新日记页

		pageService.updateById(page);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        //删除日记页,只能删除最后一页
		pageService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
