package com.example.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dell
 * @date 2021/3/6
 * @description ArticleReader
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReader {
    private String name;
    private Integer age;
}
