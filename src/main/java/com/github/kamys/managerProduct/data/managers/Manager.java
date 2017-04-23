package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.managers.criteria.CriteriaHelper;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;

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
     * @param criteriaHelper contains parameters for finding T and update him.
     * @param newParameters        replacement is for found is T.
     */
    void update(CriteriaHelper<T> criteriaHelper, Parameters newParameters);

    /**
     * Use for delete T.
     *
     * @param criteriaHelper contains parameters for finding T and delete him
     * @return T is delete.
     */
    Collection<T> delete(CriteriaHelper<T> criteriaHelper);

    /**
     * Use for selection by parameters.
     *
     * @param criteriaHelper contains parameters for finding T.
     * @return found is T.
     */
    Collection<T> select(CriteriaHelper<T> criteriaHelper);

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
