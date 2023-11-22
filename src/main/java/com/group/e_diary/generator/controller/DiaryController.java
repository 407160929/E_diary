package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.e_diary.generator.entity.DiaryEntity;
import com.group.e_diary.generator.service.DiaryService;
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
@RequestMapping("api/diary")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    /**
     * 列表
     */
    @RequestMapping("/list/{id}")
    public R list(@RequestParam Map<String, Object> params){
        //todo 获取某个用户所有日记
        PageUtils page = diaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DiaryEntity diary = diaryService.getById(id);
        //todo 获取日记
        return R.ok().put("diary", diary);
    }

    /**
     * 保存
     */
    @PostMapping ("/create")
    public R save(@RequestBody DiaryEntity diary){
		diaryService.save(diary);
        //todo 创建日记
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiaryEntity diary){
		diaryService.updateById(diary);
        //todo 更新日记
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		diaryService.removeByIds(Arrays.asList(ids));
        //todo 删除日记
        return R.ok();
    }

}
