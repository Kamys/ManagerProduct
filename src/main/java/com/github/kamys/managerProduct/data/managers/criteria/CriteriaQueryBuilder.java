package com.github.kamys.managerProduct.data.managers.criteria;

import org.apache.log4j.Logger;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Use for create and setting criteria for T.
 */
public class CriteriaQueryBuilder<T> {
    private static final Logger LOGGER = Logger.getLogger(CriteriaQueryBuilder.class);
    private final Class<T> classT;
    private final Parameters parameters;

    CriteriaQueryBuilder(Class<T> classT, Parameters parameters) {
        this.classT = classT;
        this.parameters = parameters;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public CriteriaQuery<T> createCriteriaSelect(CriteriaBuilder criteriaBuilder) {

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classT);
        Root<T> layoutRoot = criteriaQuery.from(classT);
        criteriaQuery.select(layoutRoot);

        Map<String, Parameters.Parameter> mapParameterForSelect
                = parameters.sortParameterForSelect();

        LOGGER.info("createCriteriaSelect: mapCriteria = " + mapParameterForSelect);

        List<Predicate> predicates = createPredicates(criteriaBuilder, layoutRoot);
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        return criteriaQuery;
    }

    public CriteriaUpdate<T> createCriteriaUpdate(CriteriaBuilder criteriaBuilder, Parameters manager) {
        CriteriaUpdate<T> update = criteriaBuilder.createCriteriaUpdate(classT);
        Root<T> layoutRoot = update.from(classT);

        List<Predicate> predicates = createPredicates(criteriaBuilder, layoutRoot);
        update.where(predicates.toArray(new Predicate[]{}));

        Map<String, Parameters.Parameter> mapParameterForUpdate
                = manager.sortParameterForUpdate();
        for (String key : mapParameterForUpdate.keySet()) {
            Parameters.Parameter param = mapParameterForUpdate.get(key);
            Object value = param.getValue();
            Path<Object> nameParameter = layoutRoot.get(key);
            LOGGER.debug("createCriteriaUpdate: Update set = " + nameParameter + " value = " + value);
            update.set(nameParameter, value);
        }

        return update;
    }

    private List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root<T> layoutRoot) {
        LOGGER.debug("createPredicates()");
        List<Predicate> predicates = new ArrayList<>();
        Map<String, Parameters.Parameter> mapCriteria = parameters.sortParameterForSelect();
        for (String key : mapCriteria.keySet()) {
            Parameters.Parameter param = mapCriteria.get(key);
            Object value = param.getValue();
            LOGGER.debug("  add parameter " + param.getName() + " = " + value);
            Path<Object> nameParameter = layoutRoot.get(key);
            predicates.add(criteriaBuilder.equal(nameParameter, value));
        }
        return predicates;
    }


    @Override
    public String toString() {
        return "CriteriaQueryBuilder{" +
                "classT=" + classT +
                '}';
    }
}
