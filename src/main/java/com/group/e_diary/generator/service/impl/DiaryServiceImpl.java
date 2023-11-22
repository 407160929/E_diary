package com.group.e_diary.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.common.utils.PageUtils;
import com.group.common.utils.Query;

import com.group.e_diary.generator.dao.DiaryDao;
import com.group.e_diary.generator.entity.DiaryEntity;
import com.group.e_diary.generator.service.DiaryService;


@Service("diaryService")
public class DiaryServiceImpl extends ServiceImpl<DiaryDao, DiaryEntity> implements DiaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DiaryEntity> page = this.page(
                new Query<DiaryEntity>().getPage(params),
                new QueryWrapper<DiaryEntity>()
        );

        return new PageUtils(page);
    }

}