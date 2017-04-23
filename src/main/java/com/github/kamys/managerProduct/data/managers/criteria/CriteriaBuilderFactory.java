package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaHelper}.
 */
public class CriteriaBuilderFactory {
    private ParametersFactory factory = new ParametersFactory();

    public CriteriaHelper<Layout> createLayout(Layout layout) {
        Parameters parameters = factory.createCriteriaManagerLayout(layout);
        return new CriteriaHelper<>(Layout.class, parameters);
    }
}
