package pe.isil.isilcatalog.service;

import java.util.List;

public interface BaseService<T, K> {
    List<T> findAll();
    T findById(K k);
    void create(T t);
    void update(T t);
    void delete(K k);
}
