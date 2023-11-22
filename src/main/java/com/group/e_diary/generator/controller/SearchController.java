package com.group.e_diary.generator.controller;


import com.group.common.utils.PageUtils;
import com.group.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/search")
public class SearchController {

    @RequestMapping("/all")
    public R search(@RequestParam Map<String, Object> params){
        //todo 全范围搜索
        return R.ok().put("page", "");
    }

    @RequestMapping("/gpt")
    public R queryGpt(@RequestParam Map<String, Object> params){
        //todo 询问chatgpt
        return R.ok().put("page", "");
    }

}
