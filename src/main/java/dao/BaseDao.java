package dao;

import java.util.List;

public interface BaseDao<T> {
    T readById(String id);
    List<T> readAll();
    T create(T newEntry);
    T update(T entry);
}
