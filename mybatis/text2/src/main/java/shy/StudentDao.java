package shy;

import java.util.List;

public interface StudentDao {

    List<Student> studentLists();

    int insertStudent(Student student);
}
