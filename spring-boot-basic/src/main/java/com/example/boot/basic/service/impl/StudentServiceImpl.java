package com.example.boot.basic.service.impl;

import com.example.boot.basic.dao.StudentDAO;
import com.example.boot.basic.entity.Student;
import com.example.boot.basic.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dell
 * @date 2021/3/16
 * @description StudentServiceImpl
 **/

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public boolean postStudent(Student student) {
        Student saveStudent = studentDAO.save(student);
        return saveStudent != null;
    }

    @Override
    public boolean updateStudent(Student student) {
        int row = studentDAO.update(student);
        return row !=0;
    }

    @Override
    public boolean deleteStudent(int id) {
        int row = studentDAO.deleteById(id);
        return row !=0;
    }
}
