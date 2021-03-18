package com.example.boot.basic.dao;

import com.example.boot.basic.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dell
 * @date 2021/3/16
 * @description StudentDAO
 **/
@Repository
public class StudentDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有学生
     * @return List<Student1>
     */
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_student ",new BeanPropertyRowMapper<>(Student.class));
    }

    /**
     * 根据id查询学生
     *
     * @param id id
     * @return Student
     */

    public List<Student> findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM t_student WHERE id = ? and deleted = 0 ",
                new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
    }

    /**
     * 新增学生
     * @param student student对象
     * @return 新增成功的student对象
     */
    public Student save(Student student) {
        String sql = "INSERT INTO t_student (student_name,github_name,nickname,hometown,birthday,constellation,mobile,qq,email,avatar,github,hobby,signature,color,create_time,update_time,deleted) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] args = {student.getStudentname(),student.getGithubname(),student.getNickname(),student.getHometown(),student.getBirthday(),student.getConstellation(),student.getMobile(),student.getQq(),student.getEmail(),student.getAvatar(),student.getGithub(),student.getHobby(),student.getSignature(),student.getColor(),student.getCreateTime(),student.getUpdateTime(),student.getDeleted()};
        int count = jdbcTemplate.update(sql,args);
        if (count == 1) {
            return student;
        }else{
            return  null;
        }
    }

    /**
     *修改同学信息
     * @param student student
     * @return int
     */
    public int update(Student student) {
        return jdbcTemplate.update("UPDATE t_student SET student_name = ?,github_name = ?,nickname = ?,hometown = ?,birthday = ?,constellation = ?,mobile = ?,qq = ?,email = ?,avatar = ?,github = ?,hobby = ?,signature = ?,color = ?,create_time = ?,update_time = ?,deleted = ? WHERE id = ? ",
                student.getStudentname(),
                student.getGithubname(),
                student.getNickname(),
                student.getHometown(),
                student.getBirthday(),
                student.getConstellation(),
                student.getMobile(),
                student.getQq(),
                student.getEmail(),
                student.getAvatar(),
                student.getGithub(),
                student.getHobby(),
                student.getSignature(),
                student.getColor(),
                student.getUpdateTime(),
                student.getCreateTime(),
                student.getDeleted(),
                student.getId());

    }

    /**
     * 按id删除以为同学
     * @param id
     * @return
     */
    public int deleteById(Integer id) {
        return jdbcTemplate.update("UPDATE t_student SET deleted = 1 WHERE id = ? ", id);
    }
}