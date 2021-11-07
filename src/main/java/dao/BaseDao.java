package dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
    Optional<T> readById(String id);
    List<T> readAll();
    T create(T newEntry);
    T update(T entry);
}
