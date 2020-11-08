package shy;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis动态代理
 */
public class TestMybatis {
    @Test
    public void testSelect(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
 /*       student.setName("s");
        student.setAge(19);*/
        List<Student> studentList = dao.selectIf(student);
        for (Student student1 : studentList){
            System.out.println("if信息"+student1);
        }
    }


@Test
    public void selectwhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student  = new Student();
//        student.setName("王");
        student.setAge(18);
        List<Student> students = dao.selectWhere(student);
        for (Student student1 : students){
            System.out.println("信息"+student1);
        }
}

@Test
      public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        String sql = "select * from student where id in";

        StringBuilder builder = new StringBuilder("");
        int init=0;
        int len = list.size();
//添加开始
    builder.append("(");
        for (Integer i : list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
//        循环结尾
    builder.append(")");
        sql = sql +builder.toString();
    System.out.println(sql);
      }

    @Test
    public void selectForeach1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student  = new Student();

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        List<Student> students = dao.selectFor(list);
        for (Student student1 : students){
            System.out.println("信息"+student1);
        }
    }

    @Test
    public void selectForeach2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student  = new Student();

        List<Student> list = new ArrayList<>();
        Student s1 = new Student();

        s1.setId(1002);
        list.add(s1);

        s1 =new Student();
        s1.setId(1005);
        list.add(s1);

        List<Student> students = dao.selectFor2(list);
        for (Student student1 : students){
            System.out.println("信息"+student1);
        }
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
//加入分页
//        PageNum 第几页，从1开始
//        pagesize 一页多少数据
        PageHelper.startPage(1,3);
        List<Student> students = dao.selectAll();
        for (Student student1 : students){
            System.out.println("信息"+student1);
        }
    }
}
