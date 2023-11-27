package com.group.e_diary.generator.entity;

import lombok.Data;

@Data
public class QueryForSearch {
    private Long userId;

    private String queryContent;
}
