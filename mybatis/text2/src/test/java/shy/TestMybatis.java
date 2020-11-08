package shy;

import org.junit.Test;

import java.util.List;

/**
 * mybatis动态代理
 */
public class TestMybatis {
    @Test
    public void  testSelectStudens(){
        StudentDao dao = new ShiXianLei();
        List<Student> studentList = dao.studentLists();
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void TestInertStudent(){
        StudentDao dao = new ShiXianLei();
        Student student = new Student();
        student.setId(1006);
        student.setName("zhang");
        student.setEmail("111");
        student.setAge(18);
        int num = dao.insertStudent(student);
        System.out.println("添加对象的数量"+num);
    }
}
