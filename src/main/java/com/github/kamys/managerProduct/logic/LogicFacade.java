package com.github.kamys.managerProduct.logic;

import com.github.kamys.managerProduct.data.managers.Manager;
import com.github.kamys.managerProduct.logic.layout.Layout;
import com.github.kamys.managerProduct.logic.section.Section;

/**
 * Using this facade for to work with logic library ManagerProduct.
 */
public interface LogicFacade {

    Manager<Layout> getLayoutManager();

    void setLayoutManager(Manager<Layout> layoutManager);

    Manager<Section> getSectionManager();

    void setSectionManager(Manager<Section> layoutManager);

}
