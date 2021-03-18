package com.example.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author dell
 * @date 2021/3/11
 * @description Student
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学生基本信息")
public class Student {
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("姓名")
    private String studentname;
    @ApiModelProperty("github昵称")
    private String githubname;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("籍贯")
    private String hometown;
    @ApiModelProperty("生日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;
    @ApiModelProperty("星座")
    private String constellation;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("QQ")
    private String qq;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像url")
    private String avatar;
    @ApiModelProperty("github主页url")
    private String github;
    @ApiModelProperty("爱好")
    private String hobby;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("喜爱的颜色")
    private String color;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
    @ApiModelProperty("是否删除")
    private Integer deleted;
}
