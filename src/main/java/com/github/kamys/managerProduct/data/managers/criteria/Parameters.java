package com.github.kamys.managerProduct.data.managers.criteria;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

//TODO: add entityManager.getMetamodel() for check key in mapCriteria.

/**
 * Use for work white {@link Parameter}.
 */
public class Parameters {
    private final Map<String, Parameter> mapCriteria = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(Parameters.class);

    void addParameter(String name, Object value) {
        mapCriteria.put(name, new Parameter(name, value, true));
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
        Map<String, Parameter> sortingMap = new HashMap<>();
        sortingMap.putAll(mapCriteria);
        sortingMap.values().removeIf(next -> !next.isUseForSelect() || next.getValue() == null);
        return sortingMap;
    }

    Map<String, Parameter> sortParameterForUpdate() {
        Map<String, Parameter> sortingMap = new HashMap<>();
        LOGGER.debug("sortParameterForUpdate: " + mapCriteria);
        sortingMap.putAll(mapCriteria);
        sortingMap.values().removeIf(next -> !next.isUseForUpdate() || next.getValue() == null);
        LOGGER.debug("sortParameterForUpdate: return" + sortingMap);
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
        private boolean useForSelect;
        /**
         * If set false, parameter ignored for update.
         */
        private boolean useForUpdate;

        private Parameter(String name, Object value, boolean useForSelect) {
            this.name = name;
            this.value = value;
            this.useForSelect = useForSelect;
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
