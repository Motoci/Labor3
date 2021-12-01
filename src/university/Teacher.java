package university;

import java.util.ArrayList;
import java.util.Iterator;

public class Teacher extends Person implements ICrudRepository<Course> {
    private ArrayList<Course> courses = new ArrayList();
    private long ID;

    public Teacher(long _ID, String _firstName, String _lastName, ArrayList<Course> _courses) {
        super(_firstName, _lastName);
        this.ID = _ID;
        this.courses = _courses;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public long getID() {
        return ID;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course findOne(long _ID) {
        Iterator current = this.courses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next();
        } while (!(course.getID() == _ID));

        return  course;
    }

    public Iterable<Course> findAll() {
        return this.courses;
    }

    public Course save(Course _course) {
        Iterator current = this.courses.iterator();
        Course course;

        while (current.hasNext()) {
            course = (Course)current.next();
            if (course.equals(_course))
                return course;
        }

        this.courses.add(_course);
        return null;
    }

    public Course delete(long _ID) {
        Iterator current = this.courses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next();
        } while (!(course.getID() == _ID));

        this.courses.remove(course);
        return course;
    }

    public Course update(Course _course) {
        Iterator current = this.courses.iterator();
        Course course;

        do {
            if (!current.hasNext())
                return null;

            course = (Course)current.next();
        } while (!(course.getID() == _course.getID()));

        course.setTitle(_course.getTitle());
        course.setTeacher(_course.getTeacher());
        course.setCredits(_course.getCredits());
        course.setMaxStudents(_course.getMaxStudents());
        course.setStudentsEnrolled(_course.getStudentsEnrolled());
        return course;
    }








}
