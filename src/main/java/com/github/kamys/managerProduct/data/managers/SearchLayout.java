package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.logic.layout.Layout;

import java.util.HashMap;
import java.util.Map;

/**
 * Use for find {@link Layout}.
 */
public class SearchLayout extends SearchCriteria<Layout> {

    public SearchLayout(Layout layout) {
        super(layout);
    }

    @Override
    public void removeAllSearch() {

    }

    @Override
    public void allSearch() {

    }

    @Override
    protected Class<Layout> getClassT() {
        return Layout.class;
    }

    @Override
    protected Map<String, Object> createMapCriteria() {
        HashMap<String, Object> map = new HashMap<>();
        Layout layout = getSearchObject();
        map.put("id", layout.getId());
        map.put("name", layout.getName());
        return map;
    }

}
