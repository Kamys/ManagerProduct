package com.github.kamys.managerProduct.data.managers.criteria;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

//TODO: add entityManager.getMetamodel() for check key in mapCriteria.

/**
 * Use for work white {@link Parameter}.
 */
public class Parameters {
    private static final Logger LOGGER = Logger.getLogger(Parameters.class);
    private final Map<String, Parameter> mapCriteria = new HashMap<>();

    void addParameter(String name, Object value) {
        mapCriteria.put(name, new Parameter(name, value));
    }

    public void removeParameter(String name) {
        mapCriteria.remove(name);
    }

    /**
     * Use not one parameter in criteria.
     */
    public void setAllUseForSelect(boolean useForSelect) {
        mapCriteria.forEach((s, parameter) -> parameter.setUseForSelect(useForSelect));
    }

    /**
     * Use all parameter in criteria.
     */
    public void setAllUseForUpdtae(boolean useForUpdate) {
        mapCriteria.forEach((s, parameter) -> parameter.setUseForSelect(useForUpdate));
    }

    /**
     * If set false, parameter ignored for select.
     *
     * @param name        need for found parameter.
     * @param useInSelect If set false, parameter ignored in select.
     */
    public void setUseForSelect(String name, boolean useInSelect) {
        mapCriteria.get(name).setUseForSelect(useInSelect);
    }

    /**
     * If set false, parameter ignored for update.
     *
     * @param name         need for found parameter.
     * @param useForUpdate If set false, parameter ignored in update.
     */
    public void setUseForUpdate(String name, boolean useForUpdate) {
        mapCriteria.get(name).setUseForUpdate(useForUpdate);
    }

    Map<String, Parameter> sortParameterForSelect() {
        LOGGER.info("sortParameterForSelect()");
        return sortParameter(next -> {
            boolean checkValue = next.getValue() == null;
            return !next.isUseForSelect() || checkValue;
        });
    }

    Map<String, Parameter> sortParameterForUpdate() {
        LOGGER.info("sortParameterForUpdate()");
        return sortParameter(next -> {
            boolean checkValue = next.getValue() == null;
            return !next.isUseForUpdate() || checkValue;
        });
    }

    /**
     * Sorting mapCriteria. For check parameter use method test from {@link Predicate}.
     *
     * @param predicate For check parameter.
     * @return Sorting mapCriteria.
     */
    private Map<String, Parameter> sortParameter(Predicate<Parameter> predicate) {
        Map<String, Parameter> sortingMap = new HashMap<>();
        sortingMap.putAll(mapCriteria);
        LOGGER.debug("sortParameter: " + sortingMap);
        Iterator<Parameter> iterator = sortingMap.values().iterator();
        while (iterator.hasNext()) {
            Parameter next = iterator.next();
            if (predicate.test(next)) {
                LOGGER.trace(" remove " + next);
                iterator.remove();
            }
        }
        LOGGER.debug("sortParameter: return" + sortingMap);
        return sortingMap;
    }

    Map<String, Parameter> getMapCriteria() {
        return mapCriteria;
    }

    public class Parameter {
        /**
         * Name parameter.
         */
        private String name;
        /**
         * Value parameter.
         */
        private Object value;
        /**
         * If set false, parameter ignored for select.
         */
        private boolean useForSelect = false;
        /**
         * If set false, parameter ignored for update.
         */
        private boolean useForUpdate = false;

        private Parameter(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        boolean isUseForUpdate() {
            return useForUpdate;
        }

        void setUseForUpdate(boolean useForUpdate) {
            this.useForUpdate = useForUpdate;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        Object getValue() {
            return value;
        }

        void setValue(Object value) {
            this.value = value;
        }

        boolean isUseForSelect() {
            return useForSelect;
        }

        void setUseForSelect(boolean useForSelect) {
            this.useForSelect = useForSelect;
        }

        @Override
        public String toString() {
            return "Parameter{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", useForSelect=" + useForSelect +
                    ", useForUpdate=" + useForUpdate +
                    '}';
        }
    }
}
