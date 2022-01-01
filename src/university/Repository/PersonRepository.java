package university.Repository;

import university.Entities.Person;
import java.util.Objects;

public class PersonRepository extends InMemoryRepository<Person> {

    public PersonRepository() {
        super();
    }

    /**
     * Add a new person
     *
     * @param _entity must be not null
     * @return the added Person object
     */
    @Override
    public Person save(Person _entity) {
        return super.save(_entity);
    }

    /**
     * Update the entity of type Person
     *
     * @param _entity must be not null
     * @return the updated Person object
     */
    @Override
    public Person update(Person _entity) {
        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("Person list is empty");

        Person personToUpdate = this.repo.stream()
                .filter(person -> Objects.equals(person.getFirstName(), _entity.getFirstName()))
                .findFirst()
                .orElseThrow();
        personToUpdate.setFirstName(_entity.getFirstName());
        personToUpdate.setLastName(_entity.getLastName());
        return personToUpdate;
    }

}
