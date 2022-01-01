package university.Entities;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;


public class Teacher extends Person {
    private long ID;
    private List<Course> courses;

    public Teacher(String _firstName, String _lastName, long _ID) {
        super(_firstName, _lastName);
        this.ID = _ID;
        this.courses = new ArrayList<>();
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public long getID() {
        return ID;
    }
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return " Teacher " + this.getFirstName() + " " + this.getLastName() + " ";
    }

    @Override
    public boolean equals(Object _o) {
        if (this == _o) return true;
        if (_o == null) return false;
        if (_o instanceof Teacher) {
            Teacher test = (Teacher) _o;
            if (this.getID() == test.getID()
                    && Objects.equals(this.getCourses(), test.getCourses() ))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.getID(), this.getCourses());
    }

    /**
     * add to Teacher's List
     * @param _course to be added
     */
    public void addCourseToList(Course _course) {
        this.courses.add(_course);
    }

    public void deleteCourseFromList(Course _course) {
        this.courses.remove(_course);
    }
}