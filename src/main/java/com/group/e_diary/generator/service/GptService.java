package com.group.e_diary.generator.service;

import com.group.common.utils.R;
import com.group.common.utils.ResponseResult;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface GptService {

    R get(String query) throws IOException;
}
