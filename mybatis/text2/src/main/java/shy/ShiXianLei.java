package shy;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShiXianLei implements StudentDao {
    @Override
    public List<Student> studentLists() {
//        获取SQLsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String  sqlId = "shy.StudentDao.studentLists";
//        执行SQL语句
        List<Student> students = sqlSession.selectList(sqlId);
        for (Student student : students){
            System.out.println(student);
        }
//        关闭线程
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
//        获取SQLsession
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        String sqlId = "shy.StudentDao.insertStudent";
//        执行SQL
        int num = sqlSession.insert(sqlId,student);
//        提交事务
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
