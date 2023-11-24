package com.group.e_diary.generator.controller;

import com.group.common.utils.R;
import com.group.common.utils.ResponseResult;
import com.group.e_diary.generator.service.GptService;
import com.group.e_diary.generator.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/util")
public class UtilController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private GptService gptService;
    @PostMapping("/upload")
    public ResponseResult uploadImg(MultipartFile img){
        return uploadService.uploadImg(img);
    }

    @PostMapping("/gpt")
    public R gpt(@RequestBody String query){
        try {
            return gptService.get(query);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
