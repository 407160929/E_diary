package com.group.e_diary.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.common.utils.PageUtils;
import com.group.e_diary.generator.entity.DiaryEntity;

import java.util.Map;

/**
 * 
 *
 * @author xuan
 * @email 407160929@qq.com
 * @date 2023-11-22 19:13:26
 */
public interface DiaryService extends IService<DiaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

