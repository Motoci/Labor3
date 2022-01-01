package university.Repository;

import java.util.List;

public interface ICrudRepository<T> {

    /**
     * returns the entire RepositoryList
     * @return a list of elements of type T
     */
    abstract List<T> findAll();

    /**
     * Stores the given entity
     * @param _entity to be stored in the appropriate container
     * @return the stored entity
     */
    T save(T _entity);

    /**
     * deletes the entity from the List
     * @param _entity to be deleted
     * @throws IllegalArgumentException if entity not in List
     */
    void delete(T _entity) throws IllegalArgumentException;

    /**
     * updates the entity with the matching ID
     * @param _entity has the new information
     * @return the updated entity
     */
    T update(T _entity);

}
