package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.managers.criteria.CriteriaQueryBuilder;

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
     * @param criteriaQueryBuilder contains parameters for finding T and update him.
     * @param newT  replacement is for found is T.
     */
    void update(CriteriaQueryBuilder<T> criteriaQueryBuilder, T newT);

    /**
     * Use for delete T.
     *
     * @param criteriaQueryBuilder contains parameters for finding T and delete him
     */
    Collection<T> delete(CriteriaQueryBuilder<T> criteriaQueryBuilder);

    /**
     * Use for selection by parameters.
     *
     * @param criteriaQueryBuilder contains parameters for finding T.
     * @return found is T.
     */
    Collection<T> select(CriteriaQueryBuilder<T> criteriaQueryBuilder);

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
