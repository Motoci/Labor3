package university.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private long ID;
    private String title;
    private int credits;
    private Teacher teacher;
    private int maxStudents;
    private List<Student> studentsEnrolled;

    public Course(long _ID, String _title, Teacher _teacher, int _maxStudents, int _credits) {
        this.title = _title;
        this.credits = _credits;
        this.teacher = _teacher;
        this.maxStudents = _maxStudents;
        this.studentsEnrolled = new ArrayList<>();
        this.ID = _ID;

        this.teacher.addCourseToList(this);
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
    public void setTeacher(Teacher _teacher) {
        this.teacher = _teacher;
    }
    public void setMaxStudents(int _maxStudents) {
        this.maxStudents = _maxStudents;
    }
    public void setStudentsEnrolled(List<Student> _studentsEnrolled) {
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
    public Teacher getTeacher() {
        return teacher;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    @Override
    public String toString() {
        return "Course " + this.getTitle() + " ";
    }

    @Override
    public boolean equals(Object _o) {
        if (this == _o) return true;
        if (_o == null) return false;
        if (_o instanceof Course) {
            Course test = (Course) _o;
            if (this.getID() == test.getID()
                && Objects.equals(this.getTitle(), test.getTitle())
                && Objects.equals(this.getTeacher(), test.getTeacher())
                && this.getCredits() == test.getCredits()
                && this.getMaxStudents() == test.getMaxStudents()
                && Objects.equals(this.getStudentsEnrolled(), test.getStudentsEnrolled()))
                return true;
        }
        return false;
    }

    /**
     * check for course availability
     * @return true if there are any empty places
     */
    public boolean isFree() {
        return this.getStudentsEnrolled().size() < this.getMaxStudents();
    }

    /**
     * @return number of available places
     */
    public int getNrAvailablePlaces() {
        return this.getMaxStudents() - getStudentsEnrolled().size();
    }

    /**
     * add student to the courses list of enrolled students
     * @param _student to be added
     */
    public void addStudent(Student _student) {
        this.studentsEnrolled.add(_student);
    }

    /**
     * get list of ID's for all the enrolled students
     * @return list of ID's
     */
    public List<Long> getIDEnrolledStudents() {
        List<Long> enrolledStudentsIDs = new ArrayList<>();
        for (Student student : this.studentsEnrolled)
            enrolledStudentsIDs.add(student.getID());

        return enrolledStudentsIDs;
    }

    public String toStringNameOnly() {
        return this.getTitle();
    }
}

