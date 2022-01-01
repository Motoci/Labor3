package university.Repository;

import university.Entities.Course;
import java.util.Objects;

public class CourseRepository extends InMemoryRepository<Course> {
    public CourseRepository() {
        super();
    }

    /**
     * Update the entity of type Course
     * @param _entity to be updated
     * @return the updated entity
     * @throws IndexOutOfBoundsException if Course list empty
     */
    @Override
    public Course update(Course _entity) {
        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("Course list is empty");

        Course courseToUpdate = this.repo.stream()
                .filter(course -> course.getID() == _entity.getID())
                .findFirst()
                .orElseThrow();
        courseToUpdate.setTitle(_entity.getTitle());
        courseToUpdate.setTeacher(_entity.getTeacher());
        courseToUpdate.setCredits(_entity.getCredits());
        courseToUpdate.setMaxStudents(_entity.getMaxStudents());
        courseToUpdate.setStudentsEnrolled(_entity.getStudentsEnrolled());
        return courseToUpdate;
    }

    public String toString() {
        return "CourseRepository (" + this.repo + ")";
    }
}
