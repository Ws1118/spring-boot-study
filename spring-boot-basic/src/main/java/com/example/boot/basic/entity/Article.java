package com.example.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content","title"})

/**
 * @author dell
 * @date 2021/3/6
 * @description Article
 **/
public class Article {
   private String article;
   private Integer id;
   private String author;
   private String title;
   private String content;
   private Date createTime;
}
