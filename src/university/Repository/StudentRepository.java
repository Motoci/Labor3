package university.Repository;

import university.Entities.Student;
import university.Entities.Teacher;

public class StudentRepository extends InMemoryRepository<Student> {

    public StudentRepository() {
        super();
    }

    /**
     * Update the entity of the type Student whose ID matches given entity
     * @param _entity to be updated
     * @return updated entity
     * @throws IndexOutOfBoundsException if List is empty
     */
    @Override
    public Student update(Student _entity) {

        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("Student list is Empty");

        Student studentToUpdate = this.repo.stream()
                .filter(student -> student.getID() == _entity.getID())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setFirstName(_entity.getFirstName());
        studentToUpdate.setLastName(_entity.getLastName());
        studentToUpdate.setTotalCredits(_entity.getTotalCredits());
        studentToUpdate.setEnrolledCourses(_entity.getEnrolledCourses());
        return studentToUpdate;
    }

    @Override
    public String toString() {
        return "StudentRepo (" + this.repo + ")";
    }
}
