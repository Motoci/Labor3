package university.Repository;

import university.Entities.Teacher;

public class TeacherRepository extends InMemoryRepository<Teacher> {

    public TeacherRepository() {
        super();
    }

    /**
     * Update the entity of type Teacher
     *
     * @param _entity must not be null
     * @return the updated Entity
     */
    @Override
    public Teacher update(Teacher _entity) {
        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("Teacher List is Empty");

        Teacher teacherToUpdate = this.repo.stream()
                .filter(teacher -> teacher.getID() == _entity.getID())
                .findFirst()
                .orElseThrow();
        teacherToUpdate.setFirstName(_entity.getFirstName());
        teacherToUpdate.setLastName(_entity.getLastName());
        teacherToUpdate.setCourses(_entity.getCourses());
        return teacherToUpdate;
    }

    @Override
    public String toString() {
        return "TeacherRepository (" + this.repo + ")";
    }
}
