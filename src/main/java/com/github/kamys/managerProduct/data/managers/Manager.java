package com.github.kamys.managerProduct.data.managers;

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
     * @param searchCriteria contains parameters for finding T and update him.
     * @param newT  replacement is for found is T.
     */
    void update(SearchCriteria<T> searchCriteria, T newT);

    /**
     * Use for delete T.
     *
     * @param searchCriteria contains parameters for finding T and delete him
     */
    Collection<T> delete(SearchCriteria<T> searchCriteria);

    /**
     * Use for selection by parameters.
     *
     * @param searchCriteria contains parameters for finding T.
     * @return found is T.
     */
    Collection<T> select(SearchCriteria<T> searchCriteria);

    /**
     * Use for selection all T.
     *
     * @return all T.
     */
    Collection<T> selectAll();

    /**
     * Use for complete operation.
     * Close stream which work with T.
     */
    void close();
}
