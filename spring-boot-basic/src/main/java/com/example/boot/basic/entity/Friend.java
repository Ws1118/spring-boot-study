package com.example.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dell
 * @date 2021/3/9
 * @description Friend
 **/
@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "family.child.friends")
public class Friend {
    private String hobby;
    private String gender;
}
