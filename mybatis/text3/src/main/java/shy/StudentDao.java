package shy;

import java.util.List;

public interface StudentDao {
//    动态SQL，使用java对象作为参数
    List<Student> selectIf(Student student);
    List<Student> selectWhere(Student student);
//    foreach 用法1
    List<Student> selectFor(List<Integer> idlist);

    //    foreach 用法2
    List<Student> selectFor2(List<Student> student);

//    创建pagehelper分页
    List<Student> selectAll();
}
