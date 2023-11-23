package com.group.e_diary.generator.service;

import com.group.common.utils.R;
import com.group.common.utils.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult uploadImg(MultipartFile img);
}
