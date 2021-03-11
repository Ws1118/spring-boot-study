package com.example.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * @author dell
 * @date 2021/3/9
 * @description Father
 **/
@Data
@Component
public class Father {
    private String name;
    @Min(20)
    private Integer age;
}
