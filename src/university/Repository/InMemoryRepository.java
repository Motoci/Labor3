package university.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements ICrudRepository<T> {
    protected List<T> repo;

    /**
     * set up the arraylist for each repository
     */
    public InMemoryRepository() {
        this.repo = new ArrayList<>();
    }

    /**
     * @return all the entities from the list
     */
    @Override
    public List<T> findAll() {
        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("The List is empty.");

        return this.repo;
    }

    /**
     * removes the entity
     * @param _entity must have ID of an object already in the list
     * @throws IllegalArgumentException if no stored entities match
     */
    @Override
    public void delete(T _entity) {
        if (this.repo.isEmpty())
            throw new IndexOutOfBoundsException("The List is empty.");
        if (this.repo.contains(_entity))
            this.repo.remove(_entity);
        else
            throw new IllegalArgumentException("ID of given parameter does not match.");
    }

    /**
     * store the object in the repository
     * @param _entity to be saved
     * @return the new added entity
     * @throws IllegalArgumentException if entity already in the List
     */
    @Override
    public T save(T _entity) throws IllegalArgumentException {
        if (repo.contains(_entity))
            throw new IllegalArgumentException();

        this.repo.add(_entity);
        return _entity;
    }
}
