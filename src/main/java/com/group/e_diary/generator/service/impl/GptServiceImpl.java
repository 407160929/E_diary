package com.group.e_diary.generator.service.impl;

import com.group.common.utils.R;
import com.group.e_diary.generator.service.GptService;
import org.springframework.stereotype.Service;


@Service
public class GptServiceImpl implements GptService {

    @Override
    public R get(String query) {

        return R.ok();
    }
}
