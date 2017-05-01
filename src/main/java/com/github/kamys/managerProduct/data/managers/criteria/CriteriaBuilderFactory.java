package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaHelper}.
 */
public class CriteriaBuilderFactory {
    public static CriteriaHelper<Layout> createCriteriaForLayout(Layout layout) {
        ParametersFactory factory = new ParametersFactory();
        Parameters parameters = factory.createCriteriaManagerLayout(layout);
        return new CriteriaHelper<>(Layout.class, parameters);
    }
}
