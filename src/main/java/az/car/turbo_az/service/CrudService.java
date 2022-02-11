package az.car.turbo_az.service;

import java.util.List;

public interface CrudService<T, R> {

    R create(T t);

    R findById(Long id);

    List<R> findAll();

    R update(Long id, T t);
}
