package com.group.e_diary.generator.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.common.utils.PageUtils;
import com.group.common.utils.R;
import com.group.e_diary.generator.entity.DiaryEntity;
import com.group.e_diary.generator.entity.DiaryPageRelation;
import com.group.e_diary.generator.entity.PageEntity;
import com.group.e_diary.generator.entity.QueryForSearch;
import com.group.e_diary.generator.service.DiaryService;
import com.group.e_diary.generator.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/search")
public class SearchController {

    @Autowired
    DiaryService diaryService;

    @Autowired
    PageService pageService;

    @PostMapping("/diaryPage")
    public R search(@RequestBody QueryForSearch query){
        //todo 全范围搜索
        Long userId = query.getUserId();
        List<DiaryPageRelation> diaryPageRelationList=new ArrayList<>();
        List<DiaryEntity> diaryEntities = diaryService.list(new QueryWrapper<DiaryEntity>().eq("user_id", userId));
        for (DiaryEntity diaryEntity : diaryEntities) {
            List<PageEntity> pageEntities = pageService.list(new QueryWrapper<PageEntity>().eq("diary_id", diaryEntity.getId()).like("text_content",query.getQueryContent()));
            for (PageEntity pageEntity : pageEntities) {
                DiaryPageRelation diaryPageRelation = new DiaryPageRelation();
                diaryPageRelation.setDiaryId(diaryEntity.getId());
                diaryPageRelation.setPageId(pageEntity.getId());
                diaryPageRelation.setDiaryName(diaryEntity.getName());
                diaryPageRelationList.add(diaryPageRelation);
            }
        }
        return R.ok().put("data", diaryPageRelationList);
    }


}
