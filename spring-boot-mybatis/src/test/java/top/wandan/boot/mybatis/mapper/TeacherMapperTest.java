package top.wandan.boot.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.wandan.boot.mybatis.domain.Teacher;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void selectAll() {
        List<Teacher> teachers = teacherMapper.selectAll();
        System.out.println(teachers);
    }
//
//    @Test
//    void findAll() {
//        List<Teacher> teacherList = teacherMapper.findAll();
//        System.out.println(teacherList);
//    }

    @Test
    void deleteByPrimaryKey(){
    }

    @Test
    void insert() {
        Teacher teacher = Teacher.builder()
                .teacherName("李老师")
                .clazzId(1)
                .build();
        teacherMapper.insert(teacher);
    }
}