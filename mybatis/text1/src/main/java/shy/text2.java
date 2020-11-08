package shy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class text2 {
    public static void main(String[] args) throws IOException {
//        访问mybatis读取数据

//        5获取SqlSessionFactory对象 ，从SqlSessionFactory中获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//       重点 6 指定要执行的SQL语句标识。 SQL映射文件中的namespace+.+标签的id值
//        定位文件SQL语句
        String sqlId = "shy.studentDao"+"."+"selectStudent";
//        重点 7执行SQL语句，通过SQLId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
//        8输出结果
//        studentList.forEach(stu -> System.out.println(stu));
        for (Student stu : studentList){
            System.out.println("查询"+stu);
        }

//        9 关闭SqlSession对象
        sqlSession.close();
    }
}
