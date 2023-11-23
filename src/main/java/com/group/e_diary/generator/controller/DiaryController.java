package com.group.e_diary.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    @GetMapping("/list/{id}")
    public R list(@PathVariable("id") Long id){
        //获取某个用户所有日记
        List<DiaryEntity> diaryEntities = diaryService.list(new QueryWrapper<DiaryEntity>().eq("user_id", id));
        List<Long> list = diaryEntities.stream().map(diaryEntity -> diaryEntity.getId()).collect(Collectors.toList());
        return R.ok().put("data",list);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DiaryEntity diary = diaryService.getById(id);
        //获取日记
        return R.ok().put("diary", diary);
    }

    /**
     * 保存
     */
    @PostMapping ("/create")
    public R save(@RequestBody DiaryEntity diary){
        //创建日记
		diaryService.save(diary);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody DiaryEntity diary){
        //更新日记
		diaryService.updateById(diary);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody int diaryId){
        //删除日记
        diaryService.removeById(diaryId);
        return R.ok();
    }

}
