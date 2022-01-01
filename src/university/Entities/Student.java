package university.Entities;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Student extends Person {
    private long ID;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student(String _firstName, String _lastName, long _ID) {
        super(_firstName, _lastName);
        this.ID = _ID;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

    public void setEnrolledCourses(List<Course> _enrolledCourses) {
        this.enrolledCourses = _enrolledCourses;
    }

    public void setID(long _ID) {
        this.ID = _ID;
    }

    public void setTotalCredits(int _totalCredits) {
        this.totalCredits = _totalCredits;
    }

    public long getID() {
        return ID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student " + this.getFirstName() + " " + this.getLastName() + " ";
    }

    @Override
    public boolean equals(Object _o) {
        if (this == _o) return true;
        if (_o == null) return false;
        if (_o instanceof Student) {
            Student test = (Student) _o;
            if (this.getID() == test.getID()
                && this.getTotalCredits() == test.getTotalCredits()
                && Objects.equals(this.getEnrolledCourses(), test.getEnrolledCourses()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getID(), getTotalCredits(), getEnrolledCourses());
    }

    /**
     * deletes course from student's List and subtracts credits for removed course
     */
    public void leaveCourse(Course _course) {
        this.enrolledCourses.remove(_course);
        this.totalCredits -= _course.getCredits();
    }

    /**
     *  determine number or remaining credits to pass the year
     * @return subtraction between 30 and current number or credits
     */
    public int getRemainingCredits() {
        return 30 - this.getTotalCredits();
    }

    /**
     * we add the enrolled course to the students list of courses and increment his credit number
     * @param _course is the course for which the student just enrolled
     */
    public void enroll(Course _course) {
        this.enrolledCourses.add(_course);
        this.totalCredits += _course.getCredits();
    }

    public void printCourses() {
        System.out.print("Student " + this.getFirstName() + " enrolled Courses: ");
        for (Course c : this.enrolledCourses)
            System.out.print(c.toStringNameOnly() + " ");

        System.out.println();
    }

}