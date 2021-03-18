package com.example.boot.basic.controller;

import com.example.boot.basic.controller.dto.AjaxResponse;
import com.example.boot.basic.entity.Student;
import com.example.boot.basic.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dell
 * @date 2021/3/16
 * @description StudentController
 **/
@RestController
@RequestMapping(value = "api/students")
@Slf4j
@Api(tags = "学生管理接口")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("all")
    @ApiOperation("获取所有学生信息列表")
    public AjaxResponse getAll() { return AjaxResponse.success(studentService.getAll(), "查询成功"); }

    @GetMapping("{id}")
    @ApiOperation("获取指定编号学生信息")
    public AjaxResponse findById(
            @PathVariable("id") int id) {
        return AjaxResponse.success(studentService.findById(id),"查询成功");
    }

    @PutMapping()
    @ApiOperation("修改学生信息")
    public AjaxResponse updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return AjaxResponse.success(studentService.updateStudent(student),"修改成功");
    }

    @PutMapping("body")
    @ApiOperation("增加学生信息")
    public AjaxResponse postStudent(@RequestBody Student student) {
        boolean flag = studentService.postStudent(student);
        return AjaxResponse.success(studentService.updateStudent(student),"增加成功");
    }

    @DeleteMapping()
    @ApiOperation("删除学生")
    public AjaxResponse deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return AjaxResponse.success();
    }
}
