package com.example.boot.basic.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author dell
 * @date 2021/3/9
 * @description Child
 **/
@Data
@Component
public class Child {
    private String name;
    private Integer age;
    private List<Map<String, Object>> friends;
}
