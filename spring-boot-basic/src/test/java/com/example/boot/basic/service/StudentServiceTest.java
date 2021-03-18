package com.example.boot.basic.service;

import com.example.boot.basic.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentServiceTest {

    @Resource
    private StudentService studentService;

    @Test
    void getAll() {
        List<Student> student = studentService.getAll();
        assertEquals(29,student.size());
        student.forEach(System.out::println);
    }

    @Test
    void getById() {
        List<Student> StudentList = studentService.findById(1);
        System.out.println(StudentList);
    }

    @Test
    void postStudent1() {
        Student student = Student.builder()
                .studentname("bbn")
                .githubname("bbn224")
                .nickname("百事")
                .hometown("江苏盐城")
                .birthday(LocalDate.of(2001,9,16))
                .constellation("处女座")
                .mobile("12345678987")
                .qq("12345678")
                .email("12345678@qq.com")
                .avatar("http://bnnbucket.oss-cn-hangzhou.aliyuncs.com/avatar/02.jpg")
                .github("https://github.com/bbn224")
                .hobby("吃喝玩乐")
                .signature("努力努力再努力")
                .color("#fffff")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(0)
                .build();
        log.info("student:" + student);
        boolean flag = studentService.postStudent(student);
        log.info("flag"+flag);
        assertTrue(flag);

    }

    @Test
    void update() {
        Student student = Student.builder()
                .id(30)
                .studentname("bbn")
                .githubname("bbn224")
                .nickname("百事")
                .hometown("江苏盐城")
                .birthday(LocalDate.of(2001,9,16))
                .constellation("处女座")
                .mobile("12345678987")
                .qq("12345678")
                .email("12345678@qq.com")
                .avatar("http://bnnbucket.oss-cn-hangzhou.aliyuncs.com/avatar/02.jpg")
                .github("https://github.com/bbn224")
                .hobby("吃喝玩乐")
                .signature("努力努力再努力")
                .color("#FFFFF")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(0)
                .build();
        boolean flag = studentService.updateStudent(student);
        assertTrue(flag);
    }

    @Test
    void deleteStudent() {
        boolean flag = studentService.deleteStudent(31);
        assertTrue(flag);
    }
}