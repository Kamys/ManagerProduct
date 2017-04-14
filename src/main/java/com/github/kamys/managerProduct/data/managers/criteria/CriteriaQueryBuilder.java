package com.github.kamys.managerProduct.data.managers.criteria;

import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;

/**
 * Use for create and setting criteria for T.
 */
public class CriteriaQueryBuilder<T> {
    private static final Logger LOGGER = Logger.getLogger(CriteriaQueryBuilder.class);
    private final Class<T> classT;
    private final Map<String, ParameterCriteria> mapCriteria = new HashMap<>();


    CriteriaQueryBuilder(Class<T> classT) {
        this.classT = classT;
    }

    /**
     * Use not one parameter in criteria.
     */
    public void removeUseInCriteriAll() {
        for (ParameterCriteria parameterCriteria : mapCriteria.values()) {
            parameterCriteria.setUseInCriteria(false);
        }
    }

    /**
     * Use all parameter in criteria.
     */
    public void useInCriteriaAll() {
        for (ParameterCriteria parameterCriteria : mapCriteria.values()) {
            parameterCriteria.setUseInCriteria(true);
        }
    }

    void addParameter(String name, Object value) {
        mapCriteria.put(name, new ParameterCriteria(name, value, true));
    }

    public void removeParameter(String name) {
        mapCriteria.remove(name);
    }

    /**
     * If set false, parameter ignored in criteria.
     *
     * @param name          need for found parameter.
     * @param useInCriteria If set false, parameter ignored in criteria.
     */
    public void setUseInCriteria(String name, boolean useInCriteria) {
        mapCriteria.get(name).setUseInCriteria(useInCriteria);
    }


    public CriteriaQuery<T> createCriteriaQuery(javax.persistence.criteria.CriteriaBuilder criteriaBuilder) {

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classT);
        Root<T> layoutRoot = criteriaQuery.from(classT);
        criteriaQuery.select(layoutRoot);

        LOGGER.info("createCriteriaQuery: mapCriteria = " + mapCriteria);
        for (String key : mapCriteria.keySet()) {
            ParameterCriteria param = mapCriteria.get(key);
            if (param.isUseInCriteria()) continue;
            LOGGER.debug("createCriteriaQuery: add parameter " + param.name + " = " + param.getName());
            Path<Object> nameParameter = layoutRoot.get(key);
            Object value = param.getValue();

            Predicate restriction = criteriaBuilder.equal(nameParameter, value);
            criteriaQuery.where(restriction);
        }
        return criteriaQuery;
    }

    @Override
    public String toString() {
        return "CriteriaQueryBuilder{" +
                "classT=" + classT +
                ", mapCriteria=" + mapCriteria +
                '}';
    }

    private class ParameterCriteria {
        /**
         * Name parameter.
         */
        private String name;
        /**
         * Value parameter.
         */
        private Object value;
        /**
         * If set false, parameter ignored in criteria.
         */
        private boolean useInCriteria;

        private ParameterCriteria(String name, Object value, boolean useInCriteria) {
            this.name = name;
            this.value = value;
            this.useInCriteria = useInCriteria;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private Object getValue() {
            return value;
        }

        private void setValue(Object value) {
            this.value = value;
        }

        private boolean isUseInCriteria() {
            return useInCriteria;
        }

        private void setUseInCriteria(boolean useInCriteria) {
            this.useInCriteria = useInCriteria;
        }

        @Override
        public String toString() {
            return "ParameterCriteria{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", useInCriteria=" + useInCriteria +
                    '}';
        }
    }
}
