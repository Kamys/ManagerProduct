package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.DataBaseHibernate;

import java.util.Collection;

/**
 * Need for management Attribute.
 */
public class ManagerImpl<T> implements Manager<T> {

    private DataBaseHibernate dataBase = new DataBaseHibernate();

    @Override
    public void save(T t) {
        dataBase.saveObject(t);
    }

    @Override
    public void update(T findT, T newT) {

    }

    @Override
    public Collection<T> delete(T findT) {
        return null;
    }

    @Override
    public Collection<T> select(T findT) {
        return null;
    }

    @Override
    public Collection<T> selectAll() {
        return null;
    }

    @Override
    public void close() {
        dataBase.colese();
    }
}
