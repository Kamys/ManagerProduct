package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaQueryBuilder}.
 */
public class CriteriaBuilderFactory {

    public CriteriaQueryBuilder<Layout> createLayout(Layout layout) {
        CriteriaQueryBuilder<Layout> criteria = new CriteriaQueryBuilder<>(Layout.class);
        criteria.addParameter("id", layout.getId());
        criteria.addParameter("name", layout.getName());
        return criteria;
    }
}
