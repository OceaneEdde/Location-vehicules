package com.accenture.applicationlocationvehicule.service.fake;

import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.repository.CarDao;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class FakeCarDao implements CarDao {
    public final Map<Integer, Car> store = new HashMap<>();

    @Override
    public <S extends Car> S save(S entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Car> findById(Integer integer) {
        return Optional.ofNullable(store.get(integer));
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Integer integer) {
        store.remove(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return store.containsKey(integer);
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public void delete(Car entity) {
        if (entity != null) {
            store.remove(entity.getId());
        }
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        for (Integer id : integers) {
            store.remove(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Car> entities) {
        for (Car c : entities) {
            if (c != null) {
                store.remove(c.getId());
            }
        }
    }

    @Override
    public void deleteAll() {
        store.clear();
    }

    @Override
    public <S extends Car> List<S> saveAll(Iterable<S> entities) {
        List<S> res = new ArrayList<>();
        for (S e : entities) {
            res.add(save(e));
        }
        return res;
    }

    @Override
    public List<Car> findAllById(Iterable<Integer> integers) {
        List<Car> res = new ArrayList<>();
        for (Integer id : integers) {
            Car c = store.get(id);
            if (c != null) res.add(c);
        }
        return res;
    }

    @Override
    public List<Car> findAll(Sort sort) {
        return new ArrayList<>(store.values());
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        List<Car> list = new ArrayList<>(store.values());
        return new PageImpl<>(list, pageable, list.size());
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllInBatch(Iterable<Car> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Car getOne(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Car getById(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Car getReferenceById(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> long count(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Car, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException();
    }
}
