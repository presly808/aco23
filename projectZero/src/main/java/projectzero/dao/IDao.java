package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;

import java.util.List;

public interface IDao<Key, Entity> {

    List<Entity> getAll();

    Entity getById(Key id);

    void add(Entity newEntity) throws AlreadyExistsException;

    boolean remove(Entity entity);

    Entity update(Entity entity);
}
