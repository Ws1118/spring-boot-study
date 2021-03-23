package top.wandan.boot.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.wandan.boot.mybatis.domain.Student;
import java.util.List;

/**
 * @author dell
 */
public interface StudentMapper {
    /**
     * 新增学生
     *
     * @param student student对象
     * @return int
     */
    int insert(Student student);

    /**
     * 根据id删除学生
     *
     * @param studentId 学生id
     * @return int
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 根据id查询学生
     *
     * @param studentId 学生id
     * @return 查询到的学生对象
     */
    Student selectByPrimaryKey(Integer studentId);


    /**
     * 修改学生信息
     *
     * @param student student对象
     * @return int
     */
    int updateByPrimaryKeySelective(Student student);

    /**
     * 批量新增学生
     *
     * @param students 学生集合
     * @return int
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     *
     * @param idList 待删记录id集合
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 批量修改
     *
     * @param students 学生集合
     * @return int
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 按条件单表查询，结合动态SQL
     *
     * @param student 参数对象
     * @return List<Student>
     */
    List<Student> selectByDynamicSql(Student student);
}