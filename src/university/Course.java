package university;

import java.util.ArrayList;
import java.util.Iterator;

public class Course implements ICrudRepository<Student> {
    private long ID;
    private String title;
    private int credits;
    private Person teacher;
    private int maxStudents;
    private ArrayList<Student> studentsEnrolled = new ArrayList();

    public Course(String _title, int _credits, Person _teacher, int _maxStudents, ArrayList<Student> _studentsEnrolled, long _ID) {
        this.title = _title;
        this.credits = _credits;
        this.teacher = _teacher;
        this.maxStudents = _maxStudents;
        this.studentsEnrolled = _studentsEnrolled;
        this.ID = _ID;
    }

    public void setID(long _ID) {
        this.ID = _ID;
    }
    public void setTitle(String _title) {
        this.title = _title;
    }
    public void setCredits(int _credits) {
        this.credits = _credits;
    }
    public void setTeacher(Person _teacher) {
        this.teacher = _teacher;
    }
    public void setMaxStudents(int _maxStudents) {
        this.maxStudents = _maxStudents;
    }
    public void setStudentsEnrolled(ArrayList<Student> _studentsEnrolled) {
        this.studentsEnrolled = _studentsEnrolled;
    }

    public long getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public int getCredits() {
        return credits;
    }
    public Person getTeacher() {
        return teacher;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public ArrayList<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public Student findOne(long _ID) {
        Iterator current = this.studentsEnrolled.iterator();
        Student student;

        do {
            if (!current.hasNext())
                return null;

            student = (Student)current.next();
        } while (!(student.getID() == _ID));

        return student;
    }

    public Iterable<Student> findAll() {
        return this.studentsEnrolled;
    }

    public Student save(Student _student) {
        Iterator current = this.studentsEnrolled.iterator();
        Student student;

        while (current.hasNext()) {
            student = (Student)current.next();
            if (student.equals(_student))
                return student;
        }

        this.studentsEnrolled.add(_student);
        return null;
    }

    public Student delete(long _ID) {
        Iterator current = this.studentsEnrolled.iterator();
        Student student;

        do {
            if (!current.hasNext())
                return null;

            student = (Student)current.next();
        } while (!(student.getID() == _ID));

        this.studentsEnrolled.remove(student);
        return student;
    }

    public Student update(Student _student) {
        Iterator current = this.studentsEnrolled.iterator();
        Student student;

        do {
            if (!current.hasNext())
                return null;

            student = (Student)current.next();
        } while (!(student.getID() == _student.getID()));

        student.setFirstName(_student.getFirstName());
        student.setLastName(_student.getLastName());
        student.setEnrolledCourses(_student.getEnrolledCourses());
        return student;
    }

}
