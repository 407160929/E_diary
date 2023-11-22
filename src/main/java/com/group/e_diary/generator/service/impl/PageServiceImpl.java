package com.group.e_diary.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.common.utils.PageUtils;
import com.group.common.utils.Query;

import com.group.e_diary.generator.dao.PageDao;
import com.group.e_diary.generator.entity.PageEntity;
import com.group.e_diary.generator.service.PageService;


@Service("pageService")
public class PageServiceImpl extends ServiceImpl<PageDao, PageEntity> implements PageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PageEntity> page = this.page(
                new Query<PageEntity>().getPage(params),
                new QueryWrapper<PageEntity>()
        );

        return new PageUtils(page);
    }

}