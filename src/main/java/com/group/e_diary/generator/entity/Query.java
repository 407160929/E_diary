package com.group.e_diary.generator.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Query implements Serializable {
    private static final long serialVersionUID = 1L;

    private String query;

}
