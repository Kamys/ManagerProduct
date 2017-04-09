package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link CriteriaBuilder}.
 */
public class CriteriaBuilderFactory {

    public CriteriaBuilder<Layout> createLayout(Layout layout) {
        CriteriaBuilder<Layout> criteria = new CriteriaBuilder<>(Layout.class);
        criteria.addParameter("id", layout.getId());
        criteria.addParameter("name", layout.getName());
        return criteria;
    }
}
