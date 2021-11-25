package dao;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
    Optional<T> readById(String id);
    List<T> readAll(Bson filters);
    T create(T newEntry);
    T update(T entry);
}
