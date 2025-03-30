package ua.kyrylo.bieliaiev.dao;

import java.util.Optional;

public interface Dao<T,U> {
    void save(T t);
    Optional<T> getById(U id);
    void update(T t);
    void delete(T t);
}
