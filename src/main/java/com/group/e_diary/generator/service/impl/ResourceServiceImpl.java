package com.group.e_diary.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.common.utils.PageUtils;
import com.group.common.utils.Query;

import com.group.e_diary.generator.dao.ResourceDao;
import com.group.e_diary.generator.entity.ResourceEntity;
import com.group.e_diary.generator.service.ResourceService;


@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements ResourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ResourceEntity> page = this.page(
                new Query<ResourceEntity>().getPage(params),
                new QueryWrapper<ResourceEntity>()
        );

        return new PageUtils(page);
    }

}