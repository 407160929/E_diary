package com.group.e_diary.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.common.utils.PageUtils;
import com.group.e_diary.generator.entity.PageEntity;

import java.util.Map;

/**
 * 
 *
 * @author xuan
 * @email 407160929@qq.com
 * @date 2023-11-22 19:13:26
 */
public interface PageService extends IService<PageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

