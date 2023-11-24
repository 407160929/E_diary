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
        try {
            gptService.get("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
