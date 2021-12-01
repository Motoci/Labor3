package university;

public interface ICrudRepository<T> {
    T findOne(long var);
    Iterable<T> findAll();

    T save(T var);
    T delete(long var);
    T update(T var);
}
