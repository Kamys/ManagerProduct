package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaHelper}.
 */
public class CriteriaFactory {
    public static CriteriaHelper<Layout> createCriteria(Layout layout) {
        Parameters parameters = ParametersFactory.createParameter(layout);
        return new CriteriaHelper<>(Layout.class, parameters);
    }

    public static CriteriaHelper<Layout> createCriteria(Parameters parameters) {
        return new CriteriaHelper<>(Layout.class, parameters);
    }
}
