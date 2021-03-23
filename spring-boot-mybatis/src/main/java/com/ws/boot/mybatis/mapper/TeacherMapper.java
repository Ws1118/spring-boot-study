package com.ws.boot.mybatis.mapper;

import com.ws.boot.mybatis.domain.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    /**
     * 返回所有的Teacher
     *
     * @return List<Teacher>
     */
    @Select("SELECT * FROM t_teacher ")
    List<Teacher> selectAll();

    /**
     * 返回所有的Teacher，用xml实现
     *
     * @return List<Teacher>
     */
    List<Teacher> findAll();

    void insertTeacher(Teacher teacher);
//    int deleteByPrimaryKey(Integer teacherId);
//
//    int insert(Teacher record);
//
//    int insertSelective(Teacher record);
//
//    Teacher selectByPrimaryKey(Integer teacherId);
//
//    int updateByPrimaryKeySelective(Teacher record);
//
//    int updateByPrimaryKey(Teacher record);
}