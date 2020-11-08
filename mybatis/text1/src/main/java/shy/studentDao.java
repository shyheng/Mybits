package shy;

import java.util.List;

//接口操作 student表
public interface studentDao {
//    查询student表的数据
    public List<Student> selectStudent();

//    插入方法
//    参数student，表示要插入数据库的数据
//    返回值 int ，表示执行insert操作后的，影响行数
    public int insertStudent(Student student);
}
