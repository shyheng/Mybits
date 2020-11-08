package shy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class text {
    public static void main(String[] args) throws IOException {
//        访问mybatis读取数据
//        1定义mybatis主配置文件名称,从内路径target/classes
        String config="mybatis.xml";
//        2读取config文件   读文件 Resources读取文件
        InputStream in = Resources.getResourceAsStream(config);
//        3,创建SqlSessionFactoryBuilder对象   为了创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        4创建SqlSessionFactory对象 重量级，创建一个对象耗时较长，资源较多
        SqlSessionFactory factory = builder.build(in);
//        5获取SqlSessionFactory对象 ，从SqlSessionFactory中获取sqlsession
        SqlSession sqlSession = factory.openSession();

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
