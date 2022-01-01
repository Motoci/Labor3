package university.Repository;

import university.Entities.Teacher;
import university.Entities.Student;
import university.Entities.Course;
import university.Repository.TeacherRepository;
import university.Repository.StudentRepository;
import university.Repository.CourseRepository;

import java.util.*;

public class RegistrationSystem {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public RegistrationSystem(TeacherRepository _teacherRepo, StudentRepository _studentRepo, CourseRepository _courseRepo) {
        this.teacherRepository = _teacherRepo;
        this.studentRepository = _studentRepo;
        this.courseRepository = _courseRepo;
    }


    /**
     * Enroll a student in a course
     * @param _course {@code _course} to which the registration is made
     * @param _student {@code _student} for which the registration is made
     * @return TRUE if the student has successfully enrolled in the course
     *         FALSE if course or student not enlisted in repositories
     *         FALSE if course is full.
     */
    public boolean register(Course _course, Student _student) {
        if (!courseRepository.findAll().contains(_course)) {
            System.out.println("Course not enlisted");
            return false;
        }

        if (!studentRepository.findAll().contains(_student)) {
            System.out.println("Student not enlisted");
            return false;
        }

        if (_student.getEnrolledCourses().contains(_course)) {
            System.out.println("Student already enlisted to course");
        } else {

            if (_course.isFree()) {
                _student.enroll(_course);
                _course.addStudent(_student);
                return true;
            }
        }
        return false;
    }


    /**
     * method uses map container to store each free course with its number or available places
     * @return the Hashmap
     */
    public Map<Course, Integer> availableFreePlacesForEveryCourse() {
        Map<Course, Integer> courseMap = new HashMap<>();

        for (Course course : courseRepository.findAll()) {
            if (course.isFree())
                courseMap.put(course, course.getNrAvailablePlaces());
        }
        return courseMap;
    }


    /**
     * Return the list of students enrolled in a specific course
     * @param _course given
     * @return List of students
     */
    public List<Student> studentsEnrolledInGivenCourse(Course _course) {
        return _course.getStudentsEnrolled();
    }


    /**
     * @return the List of courses not full
     */
    public List<Course> coursesNotYetFull() {
        List<Course> availableCourses = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            if (course.isFree())
                availableCourses.add(course);
        }
        return availableCourses;
    }


    /**
     * @return the list of available courses to enroll to
     */
    public List<Course> availableCourses() {
        return courseRepository.findAll();
    }

    /**
     * method loops through given information until the parameters are correct
     * @param _course has to be found in CourseRepository
     * @param _student has to be found in StudentRepository
     */
    public void enrollStudent(Course _course, Student _student) {
        Scanner keyboard = new Scanner(System.in);

        while (!register(_course, _student)) {
            System.out.println("Please choose another Course: ");
            List<Course> availableCourses = coursesNotYetFull();
            for (Course course : availableCourses) {
                System.out.println(course);
            }

            System.out.println("Enter course name from list: ");
            String input = keyboard.nextLine();

            try {
                Course testValue = courseRepository.findAll().stream()
                        .filter(variable -> Objects.equals(_course.getTitle(), input))
                        .findFirst()
                        .orElseThrow();
            } catch (Exception e) {
                System.out.println("Wrong name for Course");
            }
        }
    }

    /**
     * method loops through students to find and delete the ones enrolled in course
     * @param _teacher has to be in teacherRepo and teach the given course
     * @param _course has to be stored in courseRepo
     * @return true if course is deleted
     */
    public boolean deleteCourse(Teacher _teacher, Course _course) {
        if (!_teacher.getCourses().contains(_course))
            throw new IllegalArgumentException("Teacher does not teach the specified course");
            // return false;

        if (!teacherRepository.findAll().contains(_teacher))
            throw new IllegalArgumentException("Teacher not stored in the database");

        if (!courseRepository.findAll().contains(_course))
            throw new IllegalArgumentException("Course not stored in the database");

        _teacher.deleteCourseFromList(_course);
        for (Student _student : studentRepository.findAll())
            if (_student.getEnrolledCourses().contains(_course))
                _student.leaveCourse(_course);

        return true;
    }

    /**
     * method updates the new credit total for all students then for the course itself
     * @param _course entity whose credit number we need to modify
     * @param _credits number of new credits
     */
    public void modifyCourseCredit(Course _course, int _credits) {
        if (!courseRepository.findAll().contains(_course))
            throw new IllegalArgumentException("Course not stored in list");

        for (Student student : studentRepository.findAll()) {
            if (student.getEnrolledCourses().contains(_course)) {
                student.setTotalCredits(student.getTotalCredits() - _course.getCredits());
                student.setTotalCredits(student.getTotalCredits() + _credits);
            }
        }
        _course.setCredits(_credits);
    }





}
