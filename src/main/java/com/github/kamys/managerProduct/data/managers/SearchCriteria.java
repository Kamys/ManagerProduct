package com.github.kamys.managerProduct.data.managers;

import org.apache.log4j.Logger;

import javax.persistence.criteria.*;
import java.util.Map;

/**
 * Use for find T at hi parameters.
 * Contains data about on what parameters need find T.
 */
public abstract class SearchCriteria<T> {
    private static final Logger LOGGER = Logger.getLogger(SearchCriteria.class);
    private final T t;


    SearchCriteria(T t) {
        this.t = t;
    }

    public abstract void removeAllSearch();

    public abstract void allSearch();

    CriteriaQuery<T> createCriteria(CriteriaBuilder criteriaBuilder) {
        LOGGER.info("createCriteria: " + criteriaBuilder);
        final Class<T> classT = getClassT();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classT);
        Root<T> layoutRoot = criteriaQuery.from(classT);
        criteriaQuery.select(layoutRoot);
        Map<String, Object> mapCriteria = createMapCriteria();

        LOGGER.info("createCriteria: mapCriteria = " + mapCriteria);
        for (String key : mapCriteria.keySet()) {
            Path<Object> nameParameter = layoutRoot.get(key);
            Object value = mapCriteria.get(key);

            Predicate restriction = criteriaBuilder.equal(nameParameter, value);
            criteriaQuery.where(restriction);
        }
        return criteriaQuery;
    }

    protected abstract Class<T> getClassT();

    /**
     * Use for get data for restriction.
     *
     * @return Map with data for restriction.
     * K - name parameter.
     * V - value parameter.
     */
    protected abstract Map<String, Object> createMapCriteria();

    T getSearchObject() {
        return t;
    }
}
