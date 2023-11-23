package com.group.e_diary;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.common.utils.R;
import com.group.e_diary.generator.controller.DiaryController;
import com.group.e_diary.generator.entity.*;
import com.group.e_diary.generator.service.*;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class EDiaryApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    DiaryService diaryService;
    @Autowired
    PageService pageService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    UserResourceRelationService userResourceRelationService;
    @Test
    void contextLoads() {

        List<UserResourceRelationEntity> userResourceRelationEntities = userResourceRelationService.list(new QueryWrapper<UserResourceRelationEntity>().eq("user_id", 0));
        List<Long> list = userResourceRelationEntities.stream().map(userResourceRelation -> userResourceRelation.getResourceId()).collect(Collectors.toList());
        System.out.println(list);
    }

}
