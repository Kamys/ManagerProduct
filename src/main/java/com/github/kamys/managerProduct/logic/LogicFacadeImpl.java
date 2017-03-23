package com.github.kamys.managerProduct.logic;

import com.github.kamys.managerProduct.data.Manager;

/**
 * This default implements for LogicFacade.
 */
public class LogicFacadeImpl implements LogicFacade {
    private Manager<Layout> layoutManager;
    private Manager<Section> sectionManager;

    @Override
    public Manager<Layout> getLayoutManager() {
        return layoutManager;
    }

    @Override
    public void setLayoutManager(Manager<Layout> layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public Manager<Section> getSectionManager() {
        return sectionManager;
    }

    @Override
    public void setSectionManager(Manager<Section> sectionManager) {
        this.sectionManager = sectionManager;
    }
}
