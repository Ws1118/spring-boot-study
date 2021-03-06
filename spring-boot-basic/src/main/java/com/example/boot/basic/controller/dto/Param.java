package com.example.boot.basic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dell
 * @date 2021/3/4
 * @description Param
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private Integer id;
    private  String title;
}