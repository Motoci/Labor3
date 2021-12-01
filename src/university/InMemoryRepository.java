package university;

import java.util.ArrayList;

public abstract class InMemoryRepository<T> implements ICrudRepository<T> {

    private ArrayList<T> repo;

    public InMemoryRepository() {
        this.repo = new ArrayList<>();
    }


}
