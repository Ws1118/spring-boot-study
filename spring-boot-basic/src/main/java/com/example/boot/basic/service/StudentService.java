package com.example.boot.basic.service;

import com.example.boot.basic.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有的学生
     *
     * @return List<Student>
     */
    List<Student> getAll();

    /**
     * 根据id查询
     * @param id id
     * @return List
     */
    List<Student> findById(Integer id);

    /**
     * 增加学生
     * @param student 学生实体
     * @return boolean
     */

    boolean postStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return 更新是否成功
     */
    boolean updateStudent(Student student);

    /**
     * 删除学生信息
     * @param id
     * @retuen 是否删除成功
     */
    boolean deleteStudent(int id);
}
