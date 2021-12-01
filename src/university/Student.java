package university;

import java.util.ArrayList;
import java.util.Iterator;

public class Student extends Person implements ICrudRepository<Course> {
    private ArrayList<Course> enrolledCourses = new ArrayList();
    private long ID;
    private int totalCredits;

    public Student(ArrayList<Course> _enrolledCourses, String _firstName, String _lastName, long _ID, int _totalCredits) {
        super(_firstName, _lastName);
        this.enrolledCourses = _enrolledCourses;
        this.ID = _ID;
        this.totalCredits = _totalCredits;
    }

    public void setEnrolledCourses(ArrayList<Course> _enrolledCourses) {
        this.enrolledCourses = _enrolledCourses;
    }
    public void setID(long _ID) {
        this.ID = _ID;
    }
    public void setTotalCredits(int _totalCredits) {
        this.totalCredits = _totalCredits;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public long getID() {
        return ID;
    }
    public int getTotalCredits() {
        return totalCredits;
    }

    public Course findOne(long _ID) {
        Iterator current = this.enrolledCourses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next(); // nu verifica prima valoare ?
        } while (!(course.getID() == _ID));

        return course;
    }

    public Iterable<Course> findAll() {
        return this.enrolledCourses;
    }

    public Course save(Course _course) {
        Iterator current = this.enrolledCourses.iterator();
        Course course;

        while (current.hasNext()) {
            course = (Course)current.next();
            if (course.equals(_course))
                return course;
        }

        this.enrolledCourses.add(_course);
        return null;
    }

    public Course delete(long _ID) {
        Iterator current = this.enrolledCourses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next();
        } while (!(course.getID() == _ID));

        this.enrolledCourses.remove(course);
        return course;
    }

    public Course update(Course _course) {
        Iterator current = this.enrolledCourses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next();
        } while (!(course.getID() == _course.getID()));

        course.setTitle(_course.getTitle());
        course.setCredits(_course.getCredits());
        course.setTeacher(_course.getTeacher());
        course.setStudentsEnrolled(_course.getStudentsEnrolled());
        course.setMaxStudents(_course.getMaxStudents());
        return course;
    }
}
