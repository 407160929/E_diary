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

import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    GptService gptService;
    @Test
    void contextLoads(){
        QueryForSearch query = new QueryForSearch();
        query.setUserId(22L);
        query.setQueryContent("d");
        Long userId = query.getUserId();
        List<DiaryPageRelation> diaryPageRelationList=new ArrayList<>();
        List<DiaryEntity> diaryEntities = diaryService.list(new QueryWrapper<DiaryEntity>().eq("user_id", userId));
        for (DiaryEntity diaryEntity : diaryEntities) {
            List<PageEntity> pageEntities = pageService.list(new QueryWrapper<PageEntity>().eq("diary_id", diaryEntity.getId()).like("text_content",query.getQueryContent()));
            for (PageEntity pageEntity : pageEntities) {
                DiaryPageRelation diaryPageRelation = new DiaryPageRelation();
                diaryPageRelation.setDiaryId(diaryEntity.getId());
                diaryPageRelation.setPageId(pageEntity.getId());
                diaryPageRelationList.add(diaryPageRelation);
            }
        }
        System.out.println(diaryPageRelationList);
    }

}
