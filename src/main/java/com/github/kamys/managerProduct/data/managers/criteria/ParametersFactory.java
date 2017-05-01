package com.github.kamys.managerProduct.data.managers.criteria;

import com.github.kamys.managerProduct.logic.layout.Layout;

/**
 * Use for create and setting default {@link Parameters}.
 */
public class ParametersFactory {
    public static Parameters createParameter(Layout layout) {
        Parameters manager = new Parameters();
        manager.addParameter("id", layout.getId());
        manager.addParameter("name", layout.getName());
        return manager;
    }
}
