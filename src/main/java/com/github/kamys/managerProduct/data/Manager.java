package com.github.kamys.managerProduct.data;

import java.util.Collection;

/**
 * For use CRUD operation management on model - T.
 * T - object which management {@link Manager}.
 */
public interface Manager<T> {

    /**
     * Save T in database.
     *
     * @param t which need save.
     */
    void save(T t);

    /**
     * Use for update T in database.
     *
     * @param findT contains parameters for finding T and update him.
     * @param newT  replacement is for found is T.
     */
    void update(T findT, T newT);

    /**
     * Use for delete T.
     *
     * @param findT contains parameters for finding T and delete him
     */
    Collection<T> delete(T findT);

    /**
     * Use for selection by parameters.
     *
     * @param findT contains parameters for finding T.
     * @return found is T.
     */
    Collection<T> select(T findT);

    /**
     * Use for selection all T.
     *
     * @return all T.
     */
    Collection<T> selectAll();
}
