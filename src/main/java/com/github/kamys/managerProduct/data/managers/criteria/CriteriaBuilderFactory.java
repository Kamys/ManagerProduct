package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaQueryBuilder}.
 */
public class CriteriaBuilderFactory {
    private ParametersFactory factory = new ParametersFactory();

    public CriteriaQueryBuilder<Layout> createLayout(Layout layout) {
        Parameters parameters = factory.createCriteriaManagerLayout(layout);
        return new CriteriaQueryBuilder<>(Layout.class, parameters);
    }
}
