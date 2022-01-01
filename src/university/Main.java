package university;

import university.Entities.Course;
import university.Entities.Student;
import university.Entities.Teacher;
import university.Repository.CourseRepository;
import university.Repository.TeacherRepository;
import university.Repository.StudentRepository;
import university.Repository.RegistrationSystem;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    Student mara = new Student("Mara", "Sandru", 1);
        Student motoc = new Student("Octavian", "Motoc", 2);
        Student suteica = new Student("Gabriel", "Suteica", 3);

        StudentRepository studentsList = new StudentRepository();
        studentsList.save(mara);
        studentsList.save(motoc);
        studentsList.save(suteica);

        Teacher barbu = new Teacher("Anca", "Barbu", 4);
        Teacher radu = new Teacher("Simona", "Radu", 5);
        Teacher staroste = new Teacher("Lucian", "Staroste", 6);

        TeacherRepository teachersList = new TeacherRepository();
        teachersList.save(barbu);
        teachersList.save(radu);
        teachersList.save(staroste);

        Course physics = new Course(7, "physics", staroste, 2, 6);
        Course romanian = new Course(8, "romanian", radu, 5, 5);
        Course english = new Course(9, "english", barbu, 10, 2);
        Course math = new Course(10, "mathematics", staroste, 4, 4);

        CourseRepository coursesList = new CourseRepository();
        coursesList.save(physics);
        coursesList.save(romanian);
        coursesList.save(english);
        coursesList.save(math);

        RegistrationSystem database = new RegistrationSystem(teachersList, studentsList, coursesList);
        database.register(physics, mara);
        database.register(physics, suteica);
        database.register(english, motoc);
        database.register(english, mara);
        database.register(romanian, mara);
        database.register(math, suteica);
        database.register(math, mara);


        mara.printCourses();
        System.out.print("Entire course catalog: ");
        for (Course course : database.availableCourses())
            System.out.print(course.getTitle() + " ");
        System.out.println();

        System.out.println("Number of free places for each course: ");
        Map<Course, Integer> hashmap = database.availableFreePlacesForEveryCourse();
        hashmap.forEach((key,value) -> System.out.println("\t" + key + "has " + value + " empty places "));

        System.out.print("Courses not yet full: ");
        System.out.println(database.coursesNotYetFull());

        System.out.println("physics" + database.studentsEnrolledInGivenCourse(physics));
        System.out.println("math" + database.studentsEnrolledInGivenCourse(math));
        System.out.println("english" + database.studentsEnrolledInGivenCourse(english));
        System.out.println("romanian" + database.studentsEnrolledInGivenCourse(romanian));

        try {
            database.deleteCourse(barbu, math);

        } catch(IllegalArgumentException e) {
            System.out.println("Teacher does not teach course math");
        }

        database.deleteCourse(barbu, english);
        mara.printCourses();
        System.out.println("Total credits for mara: " + mara.getTotalCredits());

        database.modifyCourseCredit(physics, 10);
        System.out.println(physics);
        System.out.println("New number of credits for mara: " + mara.getTotalCredits());

        System.out.println("Teacher barbu currently teaches: " + barbu.getCourses());
        System.out.println("Teacher staroste currently teaches:" + staroste.getCourses());
        System.out.println("Teacher radu currently teaches: " + radu.getCourses());

    }

}
