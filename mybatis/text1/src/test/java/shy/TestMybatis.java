package shy;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
//    测试方法，测试功能
    @Test
    public void textInsert() throws IOException {
        //        1定义mybatis主配置文件名称,从内路径target/classes
        String config="mybatis.xml";
//        2读取config文件
        InputStream in = Resources.getResourceAsStream(config);
//        3,创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        4创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
//        5获取SqlSessionFactory对象 ，从SqlSessionFactory中获取sqlsession

        SqlSession sqlSession = factory.openSession(true);
//        sqlsession包含SQL语句中的方法
//        SQLsession是非线程安全所以要关闭资源
//        openSession()无参，默认是非自动提交事务。openSession(true)自动提交事务

//       重点 6 指定要执行的SQL语句标识。 SQL映射文件中的namespace+.+标签的id值
//        定位文件SQL语句
        String sqlId = "shy.studentDao"+"."+"insertStudent";
//        重点 7执行SQL语句，通过SQLId找到语句
        Student student = new Student();
        student.setId(1005);
        student.setName("zsh");
        student.setEmail("222.com");
        student.setAge(19);
        int nums = sqlSession.insert(sqlId,student);

//        mybatis默认不是自动提交事务，所以手工提供事务
//        sqlSession.commit();

//        8输出结果
//        studentList.forEach(stu -> System.out.println(stu));
        System.out.println("执行结果"+nums);

//        9 关闭SqlSession对象
        sqlSession.close();
    }
}
