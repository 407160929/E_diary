package com.group.e_diary.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.common.utils.PageUtils;
import com.group.common.utils.Query;

import com.group.e_diary.generator.dao.UserResourceRelationDao;
import com.group.e_diary.generator.entity.UserResourceRelationEntity;
import com.group.e_diary.generator.service.UserResourceRelationService;


@Service("userResourceRelationService")
public class UserResourceRelationServiceImpl extends ServiceImpl<UserResourceRelationDao, UserResourceRelationEntity> implements UserResourceRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserResourceRelationEntity> page = this.page(
                new Query<UserResourceRelationEntity>().getPage(params),
                new QueryWrapper<UserResourceRelationEntity>()
        );

        return new PageUtils(page);
    }

}